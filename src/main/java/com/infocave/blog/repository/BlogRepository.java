package com.infocave.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infocave.blog.models.BlogModel;

public interface BlogRepository extends JpaRepository<BlogModel, Long>{
	
	List<BlogModel> findAllByAuthorId(Integer authorId);

}
