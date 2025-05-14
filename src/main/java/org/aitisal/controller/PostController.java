package org.aitisal.controller;

import org.aitisal.dao.PostDAO;
import org.aitisal.dao.UserDAO;
import org.aitisal.model.Post;
import org.aitisal.model.User;

import java.util.Comparator;
import java.util.List;

import static spark.Spark.*;

public class PostController {
        public PostController(PostDAO postDao, UserDAO userDao) {
                // Créer un post
                post("/posts", (req, res) -> {
                        String authorId = req.queryParams("authorId");
                        User author = userDao.findById(authorId)
                                .orElseThrow(() -> new RuntimeException("User not found with id: " + authorId));

                        String content = req.queryParams("content");
                        if (content == null || content.trim().isEmpty()) {
                                halt(400, "Content cannot be empty");
                        }

                        Post post = new Post(author, content);
                        postDao.save(post);
                        return post;
                }, new JsonTransformer());

                // Lister tous les posts (triés par date récente)
                get("/posts", (req, res) -> {
                        List<Post> allPosts = postDao.findAll();
                        allPosts.sort(Comparator.comparing(Post::getTimestamp).reversed());
                        return allPosts;
                }, new JsonTransformer());

                // Récupérer les posts d'un utilisateur
                get("/users/:userId/posts", (req, res) -> {
                        String userId = req.params("userId");
                        User user = userDao.findById(userId)
                                .orElseThrow(() -> new RuntimeException("User not found"));

                        return postDao.findByAuthor(user);
                }, new JsonTransformer());

                // Récupérer un post spécifique
                get("/posts/:postId", (req, res) -> {
                        return postDao.findById(req.params("postId"))
                                .orElseThrow(() -> new RuntimeException("Post not found"));
                }, new JsonTransformer());
        }
}