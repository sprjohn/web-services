package com.john.example.model.user;

import com.john.example.annotations.Author;
import com.john.example.model.discoverable.Resource;

import java.util.List;

@Author(
        author="John Sprinkle",
        email="john.sprink@gmail.com")
public interface User extends Comparable<User> {
    Long getUserId();
    String getUsername();
    String getStatus();
    List<Resource> getResources();
}
