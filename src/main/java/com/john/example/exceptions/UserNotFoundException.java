package com.john.example.exceptions;

import com.john.example.annotations.Author;

@Author(
        author="John Sprinkle",
        email="john.sprink@gmail.com")
public class UserNotFoundException extends Exception {
    public UserNotFoundException(final String message) {
        super(message);
    }
}
