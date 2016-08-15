package ru.sbt.socialnetwork.registration;

public interface RegistrationService {
    void registerNewUser(String name, String password, String email);
    boolean isRegisteredUser(String name);
}
