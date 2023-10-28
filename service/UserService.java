package com.assign.commentsApi.service;
import java.util.List;

import com.assign.commentsApi.entities.Comment;



public interface UserService {
	
	boolean addComment(Comment comment);
	
	List<String> getAllComments(String commentTo);

	
	
}
