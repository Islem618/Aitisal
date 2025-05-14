package org.aitisal.unit;

import org.aitisal.algorithm.ContentRecommendation;
import org.aitisal.model.Post;
import org.aitisal.model.User;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ContentRecommendationTest {
    @Test
    public void testRecommendationOrder() {
        User user = new User("test", "test@tsn");
        Post p1 = new Post(user, "Post1");
        p1.setRelevanceScore(0.3);
        Post p2 = new Post(user, "Post2");
        p2.setRelevanceScore(0.9);

        List<Post> recommended = new ContentRecommendation()
                .recommendPosts(user, Arrays.asList(p1, p2));

        assertEquals(0.9, recommended.get(0).getRelevanceScore());
        assertEquals(2, recommended.size());
    }
}