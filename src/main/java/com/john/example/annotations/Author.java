package com.john.example.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@Author(
        author="John Sprinkle",
        email="john.sprink@gmail.com")
public @interface Author {
    String author();
    String email();
}
