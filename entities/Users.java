package com.assign.commentsApi.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * This is an Users Entity class.
 * Applied all Validation checks.
 *
 */
@Entity
@Table(name = "users_api")
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long userId;
    
	@NotBlank(message="CommentFrom should not be empty!!")
	@Pattern(regexp = "^[a-zA-Z ]+$", message = "Name should only contain letters and spaces and it cannnot be null.")
    private String commentFrom;

	@NotBlank(message="CommentTo should not be empty!!")	
	@Pattern(regexp = "^[a-zA-Z ]+$", message = "Name should only contain letters and spaces and it cannnot be null.")
    private String commentTo;


	public Users(Long userId, String commentFrom, String commentTo) {
		super();
		this.userId = userId;
		this.commentFrom = commentFrom;
		this.commentTo = commentTo;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getCommentFrom() {
		return commentFrom;
	}


	public void setCommentFrom(String commentFrom) {
		this.commentFrom = commentFrom;
	}


	public String getCommentTo() {
		return commentTo;
	}


	public void setCommentTo(String commentTo) {
		this.commentTo = commentTo;
	}
    
	
	
	
    
}

