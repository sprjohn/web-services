package com.john.example.model.user;

import com.john.example.annotations.Author;
import com.john.example.model.discoverable.Resource;

import javax.xml.bind.annotation.*;
import java.util.List;

@Author(
        author="John Sprinkle",
        email="john.sprink@gmail.com")
@XmlRootElement(name = "user")
@XmlType(name = "user", propOrder = {"userId", "username", "status", "resources"})
@XmlSeeAlso(Resource.class)
public final class UserJaxbBean {
    @XmlElement(name = "userId")
    private Long userId;
    @XmlElement(name = "username")
    private String username;
    @XmlElement(name = "status")
    private String status;
    @XmlElementWrapper(name = "resources")
    @XmlElement(name = "resource")
    private List<Resource> resources;

    /**
     * Needed for JAXB
     */
    public UserJaxbBean(){}

    public UserJaxbBean(final User user) {
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.status = user.getStatus();
        this.resources = user.getResources();
    }

    public UserJaxbBean(final Long userId, final String username, final String status, final List<Resource> resources) {
        this.userId = userId;
        this.username = username;
        this.status = status;
        this.resources = resources;
    }

    public long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getStatus() {
        return status;
    }

    public List<Resource> getResources() {
        return resources;
    }
}
