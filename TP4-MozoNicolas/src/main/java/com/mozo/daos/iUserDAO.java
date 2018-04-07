package com.mozo.daos;

import com.mozo.models.User;

import java.util.List;
/**
 * UserService's Interface
 */
public interface iUserDAO {
    /**
     * Insert a new UserService to the DB
      * @param user
     */
    void insertUser(User user);
    /**
     * Find all Users
     * @return a List of Users..
     */
    List<User> findAllUsers();
}
