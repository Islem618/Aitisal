package org.aitisal.unit;

import org.aitisal.model.SocialGraph;
import org.aitisal.model.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SocialGraphTest {
    @Test
    public void testGraphConnections() {
        SocialGraph graph = new SocialGraph();
        User u1 = new User("user1", "u1@test.com");
        User u2 = new User("user2", "u2@test.com");

        graph.addUser(u1);
        graph.addUser(u2);
        graph.addFriendship(u1, u2);

        assertEquals(1, graph.getFriends(u1).size());
        assertTrue(graph.getFriends(u1).contains(u2));
    }
}