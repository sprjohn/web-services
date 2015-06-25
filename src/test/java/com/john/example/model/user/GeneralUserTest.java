package com.john.example.model.user;

import org.junit.Test;

/**
 * Created by john on 6/24/15.
 */
public class GeneralUserTest {
    private User user;

    @Test
    public void shouldSortUsersByUserId() {
        user = new GeneralUser(1L, "One", AbstractUser.Status.ACTIVE);
        user = new GeneralUser(2L, "Two", AbstractUser.Status.ACTIVE);
        user = new GeneralUser(3L, "Three", AbstractUser.Status.ACTIVE);
    }
}
