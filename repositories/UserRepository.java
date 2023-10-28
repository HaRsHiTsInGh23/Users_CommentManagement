package com.assign.commentsApi.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import com.assign.commentsApi.entities.Users;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<Users, Long> {


	
	
}

