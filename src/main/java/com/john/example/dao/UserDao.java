package com.john.example.dao;

import com.john.example.annotations.Author;
import com.john.example.exceptions.UserAlreadyExistsException;
import com.john.example.exceptions.UserNotFoundException;
import com.john.example.model.user.GeneralUser;
import com.john.example.model.user.User;

import java.util.ArrayList;
import java.util.List;

import static com.john.example.model.user.AbstractUser.Status.ACTIVE;
import static com.john.example.model.user.AbstractUser.Status.INACTIVE;

@Author(
        author="John Sprinkle",
        email="john.sprink@gmail.com")
public class UserDao {
    public User getUserByUserId(final long userId) {
        //TODO
        if (userId == 123L) {
            return new GeneralUser(123L, "doejohn", ACTIVE);
        }
        else {
            throw new UserNotFoundException("User with id <" + userId + "> not found");
        }
    }

    public User createUser(final User newUser) {
        //TODO
        if (newUser.getUserId() == 123L) {
            throw new UserAlreadyExistsException("User with id <" + newUser.getUserId() + "> already exists");
        }

        return new GeneralUser(newUser.getUserId(), newUser.getUsername(), ACTIVE);
    }

    public List<User> getAllUsers() {
        //TODO
        final List<User> allUsers = new ArrayList<>(3);
        allUsers.add(new GeneralUser(333L, "User 333", INACTIVE));
        allUsers.add(new GeneralUser(123L, "User 123", ACTIVE));
        allUsers.add(new GeneralUser(222L, "User 222", ACTIVE));
        return allUsers;
    }
}
