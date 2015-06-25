package com.john.example.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class UserAlreadyExistsException extends WebApplicationException {
    public UserAlreadyExistsException() {
        super(Response.status(Response.Status.CONFLICT).build());
    }

    public UserAlreadyExistsException(final String msg) {
        super(Response.status(Response.Status.CONFLICT).entity(msg).type(MediaType.TEXT_PLAIN).build());
    }
}
