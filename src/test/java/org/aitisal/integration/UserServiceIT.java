package org.aitisal.integration;

import org.aitisal.dao.UserDAO;
import org.aitisal.model.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceIT {
    @Test
    public void testUserPersistence() {
        UserDAO dao = new UserDAO();
        User user = new User("testUser", "test@email.com");

        dao.save(user);
        assertTrue(dao.findById(user.getId()).isPresent());
        assertEquals("testUser", dao.findById(user.getId()).get().getUsername());
    }

    @Test
    public void testUserFriends() {
        User user1 = new User("user1", "u1@test.com");
        User user2 = new User("user2", "u2@test.com");

        user1.addFriend(user2);
        assertEquals(1, user1.getFriends().size());
        assertTrue(user1.getFriends().contains(user2));
    }
}