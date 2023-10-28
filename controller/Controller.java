package com.assign.commentsApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.assign.commentsApi.Exception.MissingParameterException;
import com.assign.commentsApi.entities.Comment;
import com.assign.commentsApi.entities.Users;
import com.assign.commentsApi.repositories.CommentRepository;
import com.assign.commentsApi.repositories.UserRepository;
import com.assign.commentsApi.service.UserServiceImpl;

import jakarta.validation.Valid;

/**
 * This is controller class , which helps us with Interacting with the HTTP Request and Response.
 *
 */
@RestController
@RequestMapping("/api/comments")
public class Controller {

	
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	@PostMapping(path = "/addComment")
	  public ResponseEntity<?> addNewComment(@RequestBody @Valid Comment comment) {
	      boolean val= userServiceImpl.addComment(comment);
	      if(val==false) {
	          return ResponseEntity.ok("Enter all the details.");
	      }
	      return ResponseEntity.ok("Comment2 Added Successfully.");
	  }
	
	
	@GetMapping(path="/getAllComments")
	public ResponseEntity<?> getAllComments2(@RequestParam String commentTo){
		if(commentTo==null || commentTo.isEmpty()) {
            throw new MissingParameterException("Parameter 'commentTo' is missing.");
		}
		List<String> messages =  userServiceImpl.getAllComments(commentTo);
		if(messages.isEmpty()) {
			return ResponseEntity.ok("Invalid Request!! Enter valid user.");
		}
		return ResponseEntity.ok().body(messages);
		
	}

}

