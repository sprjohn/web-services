package com.john.example.exceptions;

import com.john.example.annotations.Author;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Author(
        author="John Sprinkle",
        email="john.sprink@gmail.com")
public class UserNotFoundException extends WebApplicationException {
    public UserNotFoundException() {
        super(Response.status(Response.Status.NOT_FOUND).build());
    }

    public UserNotFoundException(final String msg) {
        super(Response.status(Response.Status.NOT_FOUND).entity(msg).type(MediaType.TEXT_PLAIN).build());
    }
}
