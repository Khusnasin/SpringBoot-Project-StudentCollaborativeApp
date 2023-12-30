package com.SpringBoot.app.model;

public class Comment {
	private Integer id;
    private Integer postId;
    private String content;
    
    public Comment() {
        // Default constructor
    }

    public Comment(Integer id, Integer postId, String content) {
        this.id = id;
        this.postId = postId;
        this.content = content;
    }

    // Getter methods

    public Integer getId() {
        return id;
    }

    public Integer getPostId() {
        return postId;
    }

    public String getContent() {
        return content;
    }

    // Setter methods

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
