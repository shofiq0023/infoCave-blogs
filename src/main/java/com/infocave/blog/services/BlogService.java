package com.infocave.blog.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.infocave.blog.models.BlogListResponse;
import com.infocave.blog.models.BlogModel;
import com.infocave.blog.repository.BlogRepository;

@Service
public class BlogService {
	
	private final Logger logger = LoggerFactory.getLogger(BlogService.class);
	
	@Autowired
	private BlogRepository blogRepo;
	
	
	// GET all blogs from DB
	@Cacheable(cacheNames = "blog-list")
	public BlogListResponse getAll() {
		List<BlogModel> blogs = new ArrayList<>();
		blogRepo.findAll().forEach(blogs::add);
		BlogListResponse listResponse = new BlogListResponse(blogs);
		logger.info("Getting all blogs from DB");
		return listResponse;
	}
	
	// GET single blog from DB
	@Cacheable(cacheNames = "blog", key = "#blogId")
	public Optional<BlogModel> getBlog(Long blogId) throws Exception {
		try {
			logger.info("Getting blog " + blogId + " from DB");
			return blogRepo.findById(blogId);
		} catch(Exception e) {
			throw new Exception("Something went wrong: " + e.getMessage());
		}
	}
	
	public BlogListResponse getAllByAuthor(Integer authorId) {
		List<BlogModel> blogsByAuthor = new ArrayList<>();
		blogRepo.findAllByAuthor(authorId).forEach(blogsByAuthor::add);
		BlogListResponse listResponse = new BlogListResponse(blogsByAuthor);
		return listResponse;
	}
	
	// POST adds a new blog in DB
	public BlogModel addBlog(BlogModel blog) throws Exception {
		try {
			logger.info("Adding a blog in DB");
			return blogRepo.save(blog);	
		} catch(Exception e) {
			throw new Exception("Couldn't add a blog. " + e.getMessage());
		}
	}
	
	// PUT update a blog in DB
	@CachePut(cacheNames = "blog", key = "#blogId")
	public BlogModel updateBlog(BlogModel blog, Long blogId) throws Exception {
		try {
			if(blogRepo.existsById(blogId)) {
				logger.info("updating blog in DB");
				return blogRepo.save(blog);
			} else {
				return null;
			}
		} catch(Exception e) {
			throw new Exception("Couldn't update the blog " + blogId);
		}
	}
	
	// DELETE deletes a blog from DB
	@CacheEvict(cacheNames = "blog", key = "#blogId")
	public void deleteBlog(Long blogId) {
		logger.info("Deleting blog " + blogId + " from DB");
	}
	
	@CachePut(cacheNames = "blog-list")
	public BlogListResponse updateBlogList() {
		logger.info("Updating blog list in cache");
		return getAll();
	}

}