package com.john.example.dao;

import com.john.example.annotations.Author;
import com.john.example.exceptions.UserNotFoundException;
import com.john.example.model.user.GeneralUser;
import com.john.example.model.user.User;

@Author(
        author="John Sprinkle",
        email="john.sprink@gmail.com")
public class UserDao {
    public User getUserByUserId(long userId) throws UserNotFoundException {
        if (userId == 123L) {
            return new GeneralUser(123L, "doejohn", GeneralUser.Status.ACTIVE);
        }
        else {
            throw new UserNotFoundException("User with id <" + userId + "> not found");
        }
    }
}
