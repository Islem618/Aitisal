package org.aitisal.controller;

import org.aitisal.dao.UserDAO;
import org.aitisal.model.User;
import static spark.Spark.*;

public class UserController {
    public UserController(UserDAO userDao) {
        // Créer un utilisateur
        post("/users", (req, res) -> {
            User user = new User(
                    req.queryParams("username"),
                    req.queryParams("email")
            );
            userDao.save(user);
            return user;
        }, new JsonTransformer());

        // Récupérer un utilisateur
        get("/users/:id", (req, res) -> {
            return userDao.findById(req.params(":id"))
                    .orElseThrow(() -> new RuntimeException("User not found"));
        }, new JsonTransformer());

        // Ajouter un ami
        post("/users/:id/friends", (req, res) -> {
            User user = userDao.findById(req.params(":id"))
                    .orElseThrow(() -> new RuntimeException("User not found"));
            User friend = userDao.findById(req.queryParams("friendId"))
                    .orElseThrow(() -> new RuntimeException("Friend not found"));

            user.addFriend(friend);
            userDao.save(user);
            return user;
        }, new JsonTransformer());
    }
}