package ru.sbt.socialnetwork.auth;

import ru.sbt.socialnetwork.accounts.UserProfile;

public interface AuthorizationService {
    UserProfile authorizeUser(String login, String password);
    boolean isAuthorized(String login);

}
