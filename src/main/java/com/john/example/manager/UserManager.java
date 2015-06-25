package com.john.example.manager;

import com.john.example.annotations.Author;
import com.john.example.dao.UserDao;
import com.john.example.exceptions.UserNotFoundException;
import com.john.example.model.user.GeneralUser;
import com.john.example.model.user.User;
import com.john.example.model.user.UserJaxbBean;

import java.util.Collections;
import java.util.List;

@Author(
        author="John Sprinkle",
        email="john.sprink@gmail.com")
public class UserManager {
    private final UserDao userDao;

    public UserManager(final UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUserByUserId(final String userIdStr) {
        try {
            final long userId = Long.parseLong(userIdStr);
            return userDao.getUserByUserId(userId);
        } catch (NumberFormatException e) {
            throw new UserNotFoundException("User id <" + userIdStr + "> is not valid");
        }
    }

    public User createUser(final UserJaxbBean newUserContent) {
        return userDao.createUser(new GeneralUser(newUserContent));
    }

    public List<User> getAllUsers() {
        final List<User> allUsers = userDao.getAllUsers();
        Collections.sort(allUsers);

        return userDao.getAllUsers();
    }
}
