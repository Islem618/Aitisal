package org.aitisal.algorithm;

import org.aitisal.model.Post;
import org.aitisal.model.User;
import java.util.*;
import java.util.stream.Collectors;

public class ContentRecommendation {
    public List<Post> recommendPosts(User user, List<Post> posts) {
        return posts.stream()
                .sorted(Comparator.comparingDouble(Post::getRelevanceScore).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }
}