package com.group4.front.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.group4.front.dao.IUserRepository;
import com.group4.front.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, scopeName = "singleton")
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    public User findUserById(Integer id) { return this.userRepository.findUserById(id); }

    public Integer createUser(User user) throws JsonProcessingException { return this.userRepository.createUser(user); }

    public void updateUser(User user) throws JsonProcessingException { this.userRepository.updateUser(user); }

    public void deleteUser(User user) {
        this.userRepository.deleteUser(user);
    }
}
