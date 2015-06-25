package com.john.example.model.user;

import com.john.example.annotations.Author;

import javax.xml.bind.annotation.XmlElement;

@Author(
        author="John Sprinkle",
        email="john.sprink@gmail.com")
abstract class AbstractUser implements User {
    @XmlElement(name = "userId")
    protected Long userId;
    @XmlElement(name = "username")
    protected String username;
    @XmlElement(name = "status")
    protected Status status;

    public enum Status {
        ACTIVE, INACTIVE, NONEXISTANT;
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
    public int compareTo(final User other) {
        return userId.compareTo(other.getUserId());
    }
}
