package org.aitisal.service;

import org.aitisal.model.Post;
import org.aitisal.model.User;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RecommendationService {
    public List<Post> recommendPosts(User user, List<Post> allPosts) {
        return allPosts.stream()
                .sorted(Comparator.comparingDouble(Post::getRelevanceScore).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }
}