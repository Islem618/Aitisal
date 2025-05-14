package org.aitisal.service;
import java.util.Comparator;
import java.util.stream.Collectors;
import org.aitisal.model.Post;
import java.util.*;

public class FeedService {
    // Utilisation de MergeSort adapté de TP2 pour trier les posts
    public List<Post> sortPostsByDate(List<Post> posts) {
        if (posts.size() <= 1) return posts;

        int mid = posts.size() / 2;
        List<Post> left = sortPostsByDate(posts.subList(0, mid));
        List<Post> right = sortPostsByDate(posts.subList(mid, posts.size()));

        return merge(left, right);
    }

    private List<Post> merge(List<Post> left, List<Post> right) {
        List<Post> merged = new ArrayList<>();
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getTimestamp().isAfter(right.get(j).getTimestamp())) {
                merged.add(left.get(i++));
            } else {
                merged.add(right.get(j++));
            }
        }
        merged.addAll(left.subList(i, left.size()));
        merged.addAll(right.subList(j, right.size()));
        return merged;
    }
}