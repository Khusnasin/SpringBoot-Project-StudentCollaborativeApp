package com.SpringBoot.app.model;

public class Comment {
	private Long id;
    private Long postId;
    private String content;
    
    public Comment() {
        // Default constructor
    }

    public Comment(Long id, Long postId, String content) {
        this.id = id;
        this.postId = postId;
        this.content = content;
    }

    // Getter methods

    public Long getId() {
        return id;
    }

    public Long getPostId() {
        return postId;
    }

    public String getContent() {
        return content;
    }

    // Setter methods

    public void setId(Long id) {
        this.id = id;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
