package com.work.service;

import com.work.model.Role;
import com.work.model.User;
import com.work.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setCreateTime(LocalDateTime.now());

        return userRepository.save(user);
    }

    public Optional<User> findByUserName(String username){
        return userRepository.findByUsernameEqualsIgnoreCase(username);
    }

    @Transactional
    public void makeAdmin(String username){
        userRepository.updateUserRole(username,Role.ADMIN);
    }
}
