package com.john.example.resources;

import com.john.example.annotations.Author;
import com.john.example.dao.UserDao;
import com.john.example.manager.UserManager;
import com.john.example.model.user.User;
import com.john.example.model.user.UserJaxbBean;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

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
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public UserJaxbBean getUser(@PathParam("userId") final String userId) {
        return new UserJaxbBean(userManager.getUserByUserId(userId));
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<UserJaxbBean> getAllUsers() {
        final List<User> users = userManager.getAllUsers();
        final List<UserJaxbBean> jaxbUsers = new ArrayList<>(users.size());

        for (final User user : users) {
            jaxbUsers.add(new UserJaxbBean(user));
        }

        return jaxbUsers;
    }

    @POST
    @Path("create")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createUser(final UserJaxbBean newUserContent) throws URISyntaxException {
        final User user = userManager.createUser(newUserContent);
        final URI userURI = new URI("/users/" + user.getUserId());
        return Response.created(userURI).build();
    }
}
