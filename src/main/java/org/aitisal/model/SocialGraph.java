package org.aitisal.model;

import java.util.*;

public class SocialGraph {
    private Map<User, List<User>> adjacencyList = new HashMap<>();

    public void addUser(User user) {
        adjacencyList.putIfAbsent(user, new ArrayList<>());
    }

    public void addFriendship(User user1, User user2) {
        adjacencyList.get(user1).add(user2);
        adjacencyList.get(user2).add(user1);
    }

    public List<User> getFriends(User user) {
        return adjacencyList.getOrDefault(user, new ArrayList<>());
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(adjacencyList.keySet());
    }
}