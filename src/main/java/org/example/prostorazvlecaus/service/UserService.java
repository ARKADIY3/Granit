package org.example.prostorazvlecaus.service;

import org.example.prostorazvlecaus.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User getUserByEmail(String email);
    User saveUser(User user);
    void deleteUser(Long id);
    List<User> searchUser(String name);
}