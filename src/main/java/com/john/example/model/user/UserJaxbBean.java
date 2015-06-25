package com.john.example.model.user;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by john on 6/25/15.
 */
@XmlRootElement(name = "user")
@XmlType(name = "user", propOrder = {"userId", "username", "status"})
public final class UserJaxbBean {
    @XmlElement(name = "userId")
    private Long userId;
    @XmlElement(name = "username")
    private String username;
    @XmlElement(name = "status")
    private String status;

    /**
     * Needed for JAXB
     */
    public UserJaxbBean(){}

    public UserJaxbBean(final User user) {
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.status = user.getStatus();
    }

    public UserJaxbBean(final Long userId, final String username, final String status) {
        this.userId = userId;
        this.username = username;
        this.status = status;
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
}
