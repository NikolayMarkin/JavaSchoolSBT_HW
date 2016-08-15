package ru.sbt.socialnetwork.registration;

import ru.sbt.socialnetwork.accounts.AccountService;
import ru.sbt.socialnetwork.accounts.UserProfile;

public class RegistrationServiceImpl implements RegistrationService {
    private final AccountService accountService;

    public RegistrationServiceImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void registerNewUser(String login, String password, String email) {
        UserProfile userProfile = new UserProfile(login, password, email);

        accountService.addNewUser(userProfile);
    }

    @Override
    public boolean isRegisteredUser(String login) {
        return accountService.getUserByLogin(login) != null;
    }
}
