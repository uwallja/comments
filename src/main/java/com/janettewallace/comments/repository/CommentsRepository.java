package com.janettewallace.comments.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.janettewallace.comments.model.Comments;


public interface CommentsRepository extends JpaRepository<Comments, Integer>{
	
	@Query("from Comments as c where c.user.id = :uid") //search for comments made by user of given id
	Page<Comments> findCommentsByUser(@Param("uid") int uid, Pageable p);

}
