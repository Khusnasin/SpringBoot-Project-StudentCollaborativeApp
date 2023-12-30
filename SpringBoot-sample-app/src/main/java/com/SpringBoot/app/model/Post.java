package com.SpringBoot.app.model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.List;

public class Post {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String topic;
    private Enum branch;
    private Enum semester;
    private Enum documentType;
    private String tags;
    private String files;
    private Boolean downloadEnabled;
    private Boolean commentEnabled;
    //private Integer parentId;

    @ManyToOne
    private User user;
    
    @ManyToMany
    private List<User> users = new ArrayList<>();
    
    // Constructors

    public Post() {
        // Default constructor
    }

    // Getter methods

    public Integer getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public Enum getBranch() {
        return branch;
    }

    public Enum getSemester() {
        return semester;
    }

    public Enum getDocumentType() {
        return documentType;
    }

    public String getTags() {
        return tags;
    }

    public String getFiles() {
        return files;
    }

    public Boolean getDownloadEnabled() {
        return downloadEnabled;
    }

    public Boolean getCommentEnabled() {
        return commentEnabled;
    }

    public User getUser() {
        return user;
    }

    public List<User> getUsers() {
        return users;
    }
    
    // Setter methods

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setBranch(Enum branch) {
        this.branch = branch;
    }

    public void setSemester(Enum semester) {
        this.semester = semester;
    }

    public void setDocumentType(Enum documentType) {
        this.documentType = documentType;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setFiles(String files) {
        this.files = files;
    }

    public void setDownloadEnabled(Boolean downloadEnabled) {
        this.downloadEnabled = downloadEnabled;
    }

    public void setCommentEnabled(Boolean commentEnabled) {
        this.commentEnabled = commentEnabled;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
