package com.john.example.model.user;

import com.john.example.annotations.Author;

@Author(
        author="John Sprinkle",
        email="john.sprink@gmail.com")
public final class AnonymousUser extends AbstractUser {
    private static final long ANONYMOUS_USER_ID = -1L;
    private static final String ANONYMOUS_USERNAME = "ANONYMOUS";

    @Override
    public Long getUserId() {
        return ANONYMOUS_USER_ID;
    }

    @Override
    public String getUsername() {
        return ANONYMOUS_USERNAME;
    }

    @Override
    public String getStatus() {
        return Status.NONEXISTANT.toString();
    }
}
