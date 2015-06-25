package com.john.example.model.user;

import com.john.example.annotations.Author;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Author(
        author="John Sprinkle",
        email="john.sprink@gmail.com")
@XmlRootElement(name = "user")
@XmlType(name = "user")
public final class GeneralUser extends AbstractUser {
    /**
     * Needed by JAXB
     */
    public GeneralUser(){}

    public GeneralUser(final Long userId, final String username, final Status status) {
        this.userId = userId;
        this.username = username;
        this.status = status;
    }
}
