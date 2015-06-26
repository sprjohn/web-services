package com.john.example.model.user;

import com.john.example.annotations.Author;
import com.john.example.model.discoverable.Resource;

import java.util.List;

@Author(
        author="John Sprinkle",
        email="john.sprink@gmail.com")
public final class GeneralUser extends AbstractUser {
    public GeneralUser(final Long userId, final String username, final Status status, final List<Resource> resources) {
        super(userId, username, status, resources);
    }

    public GeneralUser(final UserJaxbBean userJaxbBean) {
        super(userJaxbBean.getUserId(), userJaxbBean.getUsername(), Status.valueOf(userJaxbBean.getStatus()),
                userJaxbBean.getResources());
    }
}
