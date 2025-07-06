package org.example.prostorazvlecaus.service.impl;

import org.example.prostorazvlecaus.model.Role;
import org.example.prostorazvlecaus.model.User;
import org.example.prostorazvlecaus.repo.RoleRepository;
import org.example.prostorazvlecaus.repo.UserRepository;
import org.example.prostorazvlecaus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, 
                          RoleRepository roleRepository, 
                          PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User saveUser(User user) {
        // Если это новый пользователь (регистрация), то назначаем роль и шифруем пароль
        if(user.getId() == null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            
            // Проверяем количество пользователей в системе
            long userCount = userRepository.count();
            
            // Если первый пользователь, то даем ему роль ADMIN
            if(userCount == 0) {
                Role adminRole = roleRepository.findByName("ADMIN");
                
                if(adminRole == null) {
                    adminRole = new Role("ADMIN");
                    roleRepository.save(adminRole);
                }
                
                user.setRoles(Arrays.asList(adminRole));
            } else {
                // Для всех остальных пользователей роль USER
                Role userRole = roleRepository.findByName("USER");
                
                if(userRole == null) {
                    userRole = new Role("USER");
                    roleRepository.save(userRole);
                }
                
                user.setRoles(Arrays.asList(userRole));
            }
        }
        
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> searchUser(String searchTerm) {
        return userRepository.findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
                searchTerm,
                searchTerm
        );
    }
}