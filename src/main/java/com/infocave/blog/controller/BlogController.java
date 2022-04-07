package com.infocave.blog.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infocave.blog.models.BlogListResponse;
import com.infocave.blog.models.BlogModel;
import com.infocave.blog.services.BlogService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/blogs/")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@GetMapping("/get/all")
	public BlogListResponse getAll() {
		return blogService.getAll();
	}
	
	@GetMapping("/get/all/author/{authorId}")
	public BlogListResponse getAllByAuthor(@PathVariable("authorId") Integer authorId) {
		return blogService.getAllByAuthor(authorId);
	}
	
	@GetMapping("/get/{blogId}")
	public Optional<BlogModel> getBlog(@PathVariable("blogId") Long blogId) throws Exception {
		return blogService.getBlog(blogId);
	}
	
	@PostMapping("/add")
	public BlogModel add(@RequestBody BlogModel blog) throws Exception {
		blogService.addBlog(blog);
		updateBlogList();
		return blog;
	}
	
	@PutMapping("/update/{blogId}")
	public BlogModel updateModel(@RequestBody BlogModel blog, @PathVariable("blogId") Long blogId) throws Exception {
		blogService.updateBlog(blog, blogId);
		updateBlogList();
		return blog;
	}
	
	@DeleteMapping("/delete/{blogId}")
	public void deleteBlog(@PathVariable("blogId") Long blogId) {
		blogService.deleteBlog(blogId);
	}
	
	public void updateBlogList() {
		blogService.updateBlogList();
	}
	
}
