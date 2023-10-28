package com.assign.commentsApi.entities;



import java.util.Date;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import lombok.Setter;



/**
 * This is Comment Entity , having commentId, message , date and postedByUserId 
 * as a foreign key to the User Entity.
 * Validation Checks.
 *
 */
@Entity
@Getter
@Setter
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)	
    @Column(name = "comment_id")
    private Long commentId;

    @Column(name = "message", length = 255, nullable = false)
    @NotBlank(message="Write a message!!")
    private String message;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime ;


	@ManyToOne(targetEntity = Users.class, cascade=CascadeType.ALL)
    @JoinColumn(name="postedByUserId")
	@Valid
	private Users user;

	@PrePersist
    protected void onCreate() {
        dateTime = new Date();
    }


	public Long getCommentId() {
		return commentId;
	}

	public Comment(Long commentId, String message, Date dateTime, Users user) {
		super();
		this.commentId = commentId;
		this.message = message;
		this.dateTime = dateTime;
		this.user = user;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	
}

