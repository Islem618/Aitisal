package org.aitisal.model;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class Post {
    private String id;
    private User author;
    private String content;
    private LocalDateTime timestamp;
    private double relevanceScore;

    public Post(User author, String content) {
        this.id = UUID.randomUUID().toString();
        this.author = author;
        this.content = content;
        this.timestamp = LocalDateTime.now();
        this.relevanceScore = 0.0;
    }

    // Getters
    public String getId() { return id; }
    public User getAuthor() { return author; }
    public String getContent() { return content; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public double getRelevanceScore() { return relevanceScore; }

    // Setters
    public void setRelevanceScore(double score) { this.relevanceScore = score; }
}