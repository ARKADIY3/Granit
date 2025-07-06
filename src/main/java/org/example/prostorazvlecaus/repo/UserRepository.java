package org.example.prostorazvlecaus.repo;

import org.example.prostorazvlecaus.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    List<User> findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
            String name,
            String email
    );}