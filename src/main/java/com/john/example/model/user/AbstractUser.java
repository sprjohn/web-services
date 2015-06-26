package com.john.example.model.user;

import com.john.example.annotations.Author;
import com.john.example.model.discoverable.Resource;

import java.util.List;

@Author(
        author="John Sprinkle",
        email="john.sprink@gmail.com")
public abstract class AbstractUser implements User {
    private final Long userId;
    private final String username;
    private final Status status;
    private final List<Resource> resources;

    public enum Status {
        ACTIVE, INACTIVE, NONEXISTANT;
    }

    AbstractUser(final Long userId, final String username, final Status status, final List<Resource> resources) {
        this.userId = userId;
        this.username = username;
        this.status = status;
        this.resources = resources;
    }

    @Override
    public Long getUserId() {
        return userId;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getStatus() {
        return status.toString();
    }

    @Override
    public List<Resource> getResources() {
        return resources;
    }

    @Override
    public int compareTo(final User other) {
        return userId.compareTo(other.getUserId());
    }
}
