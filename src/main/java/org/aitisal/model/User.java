package org.aitisal.model;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String id;
    private String username;
    private String email;
    private List<User> friends;
    private PrivacySettings privacySettings;

    public User(String username, String email) {
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.email = email;
        this.friends = new ArrayList<>();
        this.privacySettings = new PrivacySettings();
    }

    public String getId() { return id; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public List<User> getFriends() { return friends; }
    public PrivacySettings getPrivacySettings() { return privacySettings; }

    public void addFriend(User friend) {
        if (!friends.contains(friend)) {
            friends.add(friend);
        }
    }
}