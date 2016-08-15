package ru.sbt.socialnetwork.messages;

import ru.sbt.socialnetwork.accounts.UserProfile;

import java.util.List;

public interface MessageService {
    void sendMessage(UserProfile from, UserProfile to, String message);

    List<Message> getMessageHistory(UserProfile user1, UserProfile user2);
}
