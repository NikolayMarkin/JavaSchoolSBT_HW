package ru.sbt.socialnetwork.accounts;

import java.util.HashMap;
import java.util.Map;

public class AccountServiceImpl implements AccountService {
    private final Map<String, UserProfile> loginToProfile;

    public AccountServiceImpl() {
        loginToProfile = new HashMap<>();
    }

    @Override
    public void addNewUser(UserProfile userProfile) {
        if (loginToProfile.containsKey(userProfile.getLogin())){
            throw new IllegalArgumentException("Пользователь с таким логином уже существует");
        }
        loginToProfile.put(userProfile.getLogin(), userProfile);
    }

    @Override
    public void updateUser(UserProfile newUserProfile) {
        if (loginToProfile.containsKey(newUserProfile.getLogin())) {
            loginToProfile.put(newUserProfile.getLogin(), newUserProfile);
        } else {
            throw new IllegalArgumentException("Пользователь с таким логином не существует");
        }
    }

    @Override
    public UserProfile getUserByLogin(String login) {
        return loginToProfile.get(login);
    }
}
