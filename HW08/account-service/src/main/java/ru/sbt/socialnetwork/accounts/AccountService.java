package ru.sbt.socialnetwork.accounts;

public interface AccountService {

    void addNewUser(UserProfile userProfile);

    void updateUser(UserProfile newUserProfile);

    UserProfile getUserByLogin(String login);
}
