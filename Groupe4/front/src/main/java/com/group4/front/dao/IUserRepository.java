package com.group4.front.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.group4.front.entities.User;

public interface IUserRepository {
    /**
     * Create user.
     *
     * @param user
     * @return User id
     */
    Integer createUser(User user) throws JsonProcessingException;

    /**
     * Return user by id.
     *
     * @param userId
     * @return
     */
    User findUserById(Integer userId);

    /**
     * Update user.
     *
     * @param user
     */
    void updateUser(User user) throws JsonProcessingException;

    /**
     * Delete user.
     *
     * @param user
     */
    void deleteUser(User user);
}
