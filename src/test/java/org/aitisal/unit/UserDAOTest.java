package org.aitisal.unit;

import org.aitisal.dao.UserDAO;
import org.aitisal.model.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserDAOTest {
    @Test
    public void testSaveAndFindUser() {
        UserDAO dao = new UserDAO();
        User user = new User("testUser", "test@email.com");

        dao.save(user);
        assertTrue(dao.findById(user.getId()).isPresent());
        assertEquals("testUser", dao.findById(user.getId()).get().getUsername());
    }

    @Test
    public void testFindNonExistentUser() {
        UserDAO dao = new UserDAO();
        assertFalse(dao.findById("non-existent-id").isPresent());
    }
}