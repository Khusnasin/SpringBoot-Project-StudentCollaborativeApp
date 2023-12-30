package com.SpringBoot.app.model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.List;

public class Profile {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Enum branch;
    private Enum semester;
    private Integer phoneNo;
    private Integer rollNo;
    private String about;
    private String hobbies;
    private String interests;
    private String githubLink;
    private String linkedInLink;
    private String imageUrl;

    @ManyToOne
    private Profile profile;
    
    @ManyToMany
    private List<Profile> profiles = new ArrayList<>();
    
    // Constructors

    public Profile() {
        // Default constructor
    }

    public Profile(Integer id,
	    Enum branch,
	    Enum semester,
	    Integer phoneNo,
	    Integer rollNo,
	    String about,
	    String hobbies,
	    String interests,
	    String githubLink,
	    String linkedInLink,
	    String imageUrl) 
    {
        this.id = id;
        this.branch = branch;
        this.semester = semester;
        this.phoneNo = phoneNo;
        this.rollNo = rollNo;
        this.about = about;
        this.hobbies = hobbies;
        this.interests = interests;
        this.githubLink = githubLink;
        this.linkedInLink = linkedInLink;
        this.imageUrl = imageUrl;
    }

    // Getter methods

    public Integer getId() {
        return id;
    }

    public Enum getBranch() {
        return branch;
    }
    public Enum getSemester() {
        return semester;
    }
    public Integer getPhoneNo() {
        return phoneNo;
    }
    public Integer getRollNo() {
        return rollNo;
    }
    public String getAbout() {
        return about;
    }

    public String getHobbies() {
        return hobbies;
    }
    
    public String getInterests() {
        return interests;
    }
    
    public String getGithubLink() {
        return githubLink;
    }
    
    public String getLinkedInLink() {
        return linkedInLink;
    }
    
    public String getImageUrl() {
        return imageUrl;
    }
    
    public Profile getProfile() {
        return profile;
    }
    
    public List<Profile> getProfiles() {
        return profiles;
    }
    
    // Setter methods
    public void setId(Integer id) {
        this.id = id;
    }

    public void setBranch(Enum branch) {
        this.branch = branch;
    }

    public void setSemester(Enum semester) {
        this.semester = semester;
    }

    public void setPhoneNo(Integer phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public void setGithubLink(String githubLink) {
        this.githubLink = githubLink;
    }

    public void setLinkedInLink(String linkedInLink) {
        this.linkedInLink = linkedInLink;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }
}
