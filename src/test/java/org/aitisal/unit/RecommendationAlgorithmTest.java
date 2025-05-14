package org.aitisal.unit;

import org.aitisal.algorithm.FriendRecommendation;
import org.aitisal.model.User;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class RecommendationAlgorithmTest {
    @Test
    public void testFriendRecommendation() {
        User u1 = new User("user1", "u1@test.com");
        User u2 = new User("user2", "u2@test.com");
        User u3 = new User("user3", "u3@test.com");

        u1.addFriend(u2);
        u2.addFriend(u3);

        List<User> allUsers = new ArrayList<>(List.of(u1, u2, u3));
        List<User> recommendations = new FriendRecommendation()
                .recommendFriends(u1, allUsers);

        assertEquals(1, recommendations.size());
        assertEquals(u3, recommendations.get(0));
    }
}