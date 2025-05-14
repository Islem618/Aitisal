package org.aitisal.algorithm;

import org.aitisal.model.SocialGraph;
import org.aitisal.model.User;
import java.util.*;

// Adapté de TP6.count_triangles() et betweenness_centrality()
public class CommunityDetection {
    public static Map<User, Integer> detectCommunities(SocialGraph graph) {
        Map<User, Integer> communities = new HashMap<>();
        Set<User> visited = new HashSet<>();
        int communityId = 0;

        for (User user : graph.getAllUsers()) {
            if (!visited.contains(user)) {
                bfsCommunityDetection(graph, user, visited, communities, communityId++);
            }
        }
        return communities;
    }

    private static void bfsCommunityDetection(SocialGraph graph, User start,
                                              Set<User> visited,
                                              Map<User, Integer> communities,
                                              int communityId) {
        Queue<User> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            User current = queue.poll();
            communities.put(current, communityId);
            for (User neighbor : graph.getFriends(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
}