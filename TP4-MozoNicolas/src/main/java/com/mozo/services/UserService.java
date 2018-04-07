package com.mozo.services;

import com.mozo.daos.UserDAO;
import com.mozo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements iUserService {

    @Autowired
    private UserDAO tUserDao;

    @Override
    // The transactional annotation itself defines the scope of a single database transaction.
    // The database transaction happens inside the scope of a persistence context.
    @Transactional
    public void insertUser(User user) {
        // Insert a user calling the DAO
        this.tUserDao.insertUser(user);
    }

    @Override
    public List<User> findAllUsers() {
        // Find all user from the DAO
        return this.tUserDao.findAllUsers();
    }
}
