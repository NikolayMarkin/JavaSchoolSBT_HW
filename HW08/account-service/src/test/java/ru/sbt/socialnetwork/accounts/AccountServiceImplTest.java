package ru.sbt.socialnetwork.accounts;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountServiceImplTest {
    AccountService accountService;

    @Before
    public void setUp() {
        accountService = new AccountServiceImpl();
    }

    @Test
    public void addNewUserTest() {
        UserProfile newUser = new UserProfile("user1", "qwerty", "user1@mail.com");

        accountService.addNewUser(newUser);

        UserProfile storedUser = accountService.getUserByLogin("user1");

        assertEquals(newUser, storedUser);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addDuplicateUserTest() {
        UserProfile newUser = new UserProfile("user1", "qwerty", "user1@mail.com");
        UserProfile newUser2 = new UserProfile("user1", "qwerty123", "user@mail.com");

        accountService.addNewUser(newUser);
        accountService.addNewUser(newUser2);
    }

    @Test
    public void updateUserTest() {
        UserProfile newUser = new UserProfile("user1", "qwerty", "user1@mail.com");
        accountService.addNewUser(newUser);

        UserProfile updatedUser = new UserProfile("user1", "qwerty123", "user1@mail.com");
        accountService.updateUser(updatedUser);

        UserProfile storedUser = accountService.getUserByLogin("user1");

        assertEquals(updatedUser, storedUser);
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateNonstoredUserTest() {
        UserProfile updatedUser = new UserProfile("user1", "qwerty123", "user1@mail.com");
        accountService.updateUser(updatedUser);
    }
}