package com.john.example.resources;

import com.john.example.annotations.Author;
import com.john.example.dao.UserDao;
import com.john.example.exceptions.UserNotFoundException;
import com.john.example.manager.UserManager;
import com.john.example.model.user.GeneralUser;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Author(
        author="John Sprinkle",
        email="john.sprink@gmail.com")
@Path("/users")
public class UserResource {
    private UserManager userManager;

    public UserResource() {
        userManager = new UserManager(new UserDao());
    }

    public UserResource(final UserManager userManager) {
        this.userManager = userManager;
    }

    @GET
    @Path("{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public GeneralUser getUserJSON(@PathParam("userId") final String userId) {
        try {
            return (GeneralUser) userManager.getUserByUserId(userId);
        } catch (UserNotFoundException e) {
            return null;
        }
    }

    @GET
    @Path("{userId}")
    @Produces(MediaType.APPLICATION_XML)
    public GeneralUser getUserXml(@PathParam("userId") final String userId) {
        try {
            return (GeneralUser) userManager.getUserByUserId(userId);
        } catch (UserNotFoundException e) {
            return null;
        }
    }
}
