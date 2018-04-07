package com.mozo.services;

import com.mozo.models.User;

import java.util.List;

public interface iUserService {
    /**
     * Insert a user to the DB
     * @param user
     */
    void insertUser(User user);
    /**
     *  Get all Users
     * @return a list of Users
     */
    List<User> findAllUsers();
}
