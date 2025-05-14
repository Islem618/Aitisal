package org.aitisal.service;

import org.aitisal.dao.UserDAO;
import org.aitisal.model.User;

public class UserService {
    private final UserDAO userDao;

    public UserService(UserDAO userDao) {
        this.userDao = userDao;
    }

    public User registerUser(String username, String email) {
        User user = new User(username, email);
        userDao.save(user);
        return user;
    }

    public void addFriend(String userId, String friendId) {
        User user = userDao.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        User friend = userDao.findById(friendId)
                .orElseThrow(() -> new RuntimeException("Friend not found"));

        user.addFriend(friend);
        userDao.save(user);
    }
}