package org.aitisal.algorithm;

import org.aitisal.model.Post;
import java.util.*;

// Adapté de TP4 (Knapsack)
public class ContentOptimizer {
    public List<Post> selectOptimalPosts(List<Post> posts, int maxVisible) {
        int n = posts.size();
        double[] values = posts.stream().mapToDouble(Post::getRelevanceScore).toArray();
        int[] weights = posts.stream().mapToInt(p -> 1).toArray(); // Poids uniforme

        double[][] dp = new double[n + 1][maxVisible + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= maxVisible; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(
                            values[i - 1] + dp[i - 1][w - weights[i - 1]],
                            dp[i - 1][w]
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Reconstruction de la solution
        List<Post> selected = new ArrayList<>();
        int w = maxVisible;
        for (int i = n; i > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                selected.add(posts.get(i - 1));
                w -= weights[i - 1];
            }
        }
        return selected;
    }
}