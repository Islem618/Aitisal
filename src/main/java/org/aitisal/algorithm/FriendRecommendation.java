package org.aitisal.algorithm;

import org.aitisal.model.User;
import java.util.*;

public class FriendRecommendation {
    public List<User> recommendFriends(User user, List<User> allUsers) {
        Set<User> recommendations = new HashSet<>();
        for (User friend : user.getFriends()) {
            for (User friendOfFriend : friend.getFriends()) {
                if (!user.getFriends().contains(friendOfFriend)) {
                    recommendations.add(friendOfFriend);
                }
            }
        }
        return new ArrayList<>(recommendations);
    }
}