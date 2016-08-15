package ru.sbt.socialnetwork.registration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ru.sbt.socialnetwork.accounts.AccountService;
import ru.sbt.socialnetwork.accounts.UserProfile;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationServiceImplTest {
    @Mock
    AccountService accountService;

    RegistrationService registrationService;

    @Before
    public void setUp() {
        registrationService = new RegistrationServiceImpl(accountService);
    }

    @Test
    public void registerNewUserTest() {
        String login = "user1";
        String password = "pass";
        String email = "user1@mail.ru";
        UserProfile newUser = new UserProfile(login, password, email);

        registrationService.registerNewUser(login, password, email);
        verify(accountService).addNewUser(newUser);
    }

    @Test(expected = IllegalArgumentException.class)
    public void registerDuplicateUserTest() {
        String login = "user1";
        String password = "pass";
        String email = "user1@mail.ru";
        UserProfile newUser = new UserProfile(login, password, email);
        doThrow(new IllegalArgumentException()).when(accountService).addNewUser(newUser);
        registrationService.registerNewUser(login, password, email);
    }

    @Test
    public void isRegisteredUserTest(){
        String login = "user1";
        String password = "pass";
        String email = "user1@mail.ru";
        UserProfile userProfile = new UserProfile(login, password, email);
        when(accountService.getUserByLogin(login)).thenReturn(userProfile);

        assertEquals(registrationService.isRegisteredUser(login), true);
    }

    @Test
    public void isRegisteredUserTestUnregistered(){
        String login = "unregister";
        when(accountService.getUserByLogin(login)).thenReturn(null);

        assertEquals(registrationService.isRegisteredUser(login), false);
    }
}