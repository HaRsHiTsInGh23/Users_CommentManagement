package com.assign.commentsApi.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.assign.commentsApi.entities.Comment;
import com.assign.commentsApi.entities.Users;
import com.assign.commentsApi.repositories.CommentRepository;
import com.assign.commentsApi.repositories.UserRepository;



/**
 * It basically a Service class where all the Business logics are written. 
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CommentRepository commentRepository;

	
	@Override
	public boolean addComment(Comment comment) {
		Users user = comment.getUser();
		if(user.getCommentTo().isBlank() || user.getCommentFrom().isBlank()) {
			return false;
		}
		commentRepository.save(comment);
		return true;
		
	}

	@Override
	public List<String> getAllComments(String commentTo) {
		List<String> messages = commentRepository.getAllMessagesToUser(commentTo);
		return messages;
	}


	
	
}
