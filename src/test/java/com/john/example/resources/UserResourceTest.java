package com.john.example.resources;

import com.john.example.Main;
import com.john.example.model.discoverable.Resource;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

public class UserResourceTest {
    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        server = Main.startServer();
        final Client c = ClientBuilder.newClient();
        target = c.target(Resource.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.shutdown();
    }

    @Test
    public void shouldGetExistingUserAsJSON() {
        final WebTarget webTarget = target.path("users/123");
        final String responseMsg = webTarget.request().header("Accept", MediaType.APPLICATION_JSON).get(String.class);
        assertEquals("doejohn", responseMsg);
    }

    @Test
    public void shouldGetExistingUserAsXML() {
        final WebTarget webTarget = target.path("users/123");
        final String responseMsg = webTarget.request().header("Accept", MediaType.APPLICATION_XML).get(String.class);
        assertEquals("doejohn", responseMsg);
    }

    @Test
    public void shouldReturnErrorMessageForNonexistentUser() {
        final WebTarget webTarget = target.path("users/456");
        final String responseMsg = webTarget.request().header("Accept", MediaType.APPLICATION_JSON).get(String.class);
        assertEquals("User with id <456> not found", responseMsg);
    }

    @Test
    public void foobar() {
        final WebTarget webTarget = target.path("users/create");
        final Response responseMsg = webTarget.request().header("Accept", MediaType.APPLICATION_JSON).post(Entity.entity("{}", MediaType.APPLICATION_JSON));
        assertEquals("User with id <456> not found", responseMsg);
    }
}
