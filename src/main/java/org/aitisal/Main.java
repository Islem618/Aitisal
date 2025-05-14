package org.aitisal;

import org.aitisal.controller.PostController;
import org.aitisal.controller.UserController;
import org.aitisal.dao.PostDAO;
import org.aitisal.dao.UserDAO;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        // Configuration du port
        port(4567);

        // Activation CORS (pour le frontend)
        enableCORS();

        // Initialisation DAO
        UserDAO userDao = new UserDAO();
        PostDAO postDao = new PostDAO();

        // Routes
        get("/", (req, res) -> {
            res.redirect("/index.html");
            return null;
        });

        // Initialisation des contrôleurs
        new UserController(userDao);
        new PostController(postDao, userDao);

        // Message de démarrage
        System.out.println("TSN Server running on http://localhost:4567");
    }

    private static void enableCORS() {
        options("/*", (req, res) -> "");

        before((req, res) -> {
            res.header("Access-Control-Allow-Origin", "*");
            res.header("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
            res.header("Access-Control-Allow-Headers", "Content-Type,Authorization");
        });
    }
}