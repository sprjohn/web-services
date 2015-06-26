package com.john.example.exceptions;

import com.john.example.annotations.Author;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Author(
        author="John Sprinkle",
        email="john.sprink@gmail.com")
public class UserAlreadyExistsException extends WebApplicationException {
    public UserAlreadyExistsException() {
        super(Response.status(Response.Status.CONFLICT).build());
    }

    public UserAlreadyExistsException(final String msg) {
        super(Response.status(Response.Status.CONFLICT).entity(msg).type(MediaType.TEXT_PLAIN).build());
    }
}
