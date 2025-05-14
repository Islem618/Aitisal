package org.aitisal.dao;

import org.aitisal.model.Post;
import org.aitisal.model.User;

import java.util.*;
import java.util.stream.Collectors;

public class PostDAO {
    private final Map<String, Post> posts = new HashMap<>();

    public void save(Post post) {
        posts.put(post.getId(), post);
    }

    public List<Post> findAll() {
        return new ArrayList<>(posts.values());
    }

    public List<Post> findByAuthor(User author) {
        return posts.values().stream()
                .filter(post -> post.getAuthor().getId().equals(author.getId()))
                .collect(Collectors.toList());
    }

    public Optional<Post> findById(String id) {
        return Optional.ofNullable(posts.get(id));
    }
}