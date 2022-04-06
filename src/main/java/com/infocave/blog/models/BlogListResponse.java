package com.infocave.blog.models;

import java.util.List;

public class BlogListResponse {
	private List<BlogModel> blogs;

	public BlogListResponse(List<BlogModel> blogs) {
		super();
		this.blogs = blogs;
	}

	public List<BlogModel> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<BlogModel> blogs) {
		this.blogs = blogs;
	}

}
