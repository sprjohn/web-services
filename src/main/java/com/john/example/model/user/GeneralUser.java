package com.john.example.model.user;

import com.john.example.annotations.Author;

@Author(
        author="John Sprinkle",
        email="john.sprink@gmail.com")
public final class GeneralUser extends AbstractUser {
    public GeneralUser(final Long userId, final String username, final Status status) {
        super(userId, username, status);
    }

    public GeneralUser(final UserJaxbBean userJaxbBean) {
        super(userJaxbBean.getUserId(), userJaxbBean.getUsername(), Status.valueOf(userJaxbBean.getStatus()));
    }
}
