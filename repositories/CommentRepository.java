package com.assign.commentsApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import com.assign.commentsApi.entities.Comment;

import jakarta.transaction.Transactional;

import java.util.List;

@EnableJpaRepositories
public interface CommentRepository extends JpaRepository<Comment, Long> {

	
	@Modifying
	@Transactional
	@Query("SELECT message FROM Comment JOIN Users  ON user.userId = userId WHERE commentTo = :commentTo")
	List<String> getAllMessagesToUser(String commentTo);
	
    
}

