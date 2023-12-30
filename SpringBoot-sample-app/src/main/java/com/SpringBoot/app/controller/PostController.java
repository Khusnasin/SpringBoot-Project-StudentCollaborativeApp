package com.SpringBoot.app.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.SpringBoot.app.model.Post;
import com.SpringBoot.app.model.Comment;
import com.SpringBoot.app.model.User;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;


@RestController
@RequestMapping("/api/posts")
public class PostController {
	private List<Post> posts = new ArrayList<>();
	private List<Comment> comments = new ArrayList<>();
	private List<User> users = new ArrayList<>();

	//private List<Reply> replies = new ArrayList<>();

	// Endpoint to get all posts related to a particular user
    @GetMapping("/user/{userId}")
    public List<Post> getPostsByUser(@PathVariable Integer userId) {
        User user = users.stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst()
                .orElse(null);

        if (user != null) {
            return posts.stream()
                    .filter(post -> post.getUser().equals(user))
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList(); // User not found
        }
    }
	
    // Endpoint to get a specific post by ID
    @GetMapping("/{postId}")
    public Post getPost(@PathVariable Integer postId) {
        
        return posts.stream()
                .filter(post -> post.getId().equals(postId))
                .findFirst()
                .orElse(null); // Return null if the post is not found
    }
    
    @PostMapping("/{postId}/comments")
    public Comment postCommentOrReply(@PathVariable Integer postId, @RequestBody Comment newComment) {
        
        newComment.setId(generateCommentId()); 
        newComment.setPostId(postId);
        comments.add(newComment);
        return newComment;
    }
    
    @PostMapping("/multi-user")
    public Post postMultiUserPost(@RequestBody Post newPost, @RequestParam List<Integer> userIds) {
        newPost.setId(generatePostId());
        
        // Add the post to the list of posts
        posts.add(newPost);

        // Link the post to each user
        for (Integer userId : userIds) {
            User user = users.stream()
                    .filter(u -> u.getId().equals(userId))
                    .findFirst()
                    .orElse(null);

            if (user != null) {
                newPost.getUsers().add(user);
            }
        }

        return newPost;
    }
    
    private Integer generatePostId() {
    	return posts.size() + 1;
	}

	// Endpoint to reply to a specific comment
    /*@PostMapping("/comments/{commentId}/replies")
    public Reply replyToComment(@PathVariable Long commentId, @RequestBody Reply newReply) {
        newReply.setId(generateReplyId());
        newReply.setCommentId(commentId);
        replies.add(newReply);
        return newReply;
    }
*/
    private Integer generateCommentId() {
        
    	return comments.size() + 1;
    }
    
   
}

