package com.infocave.blog.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "blogs")
public class BlogModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "blog_id")
	private Long blogId;

	@Column(name = "blog_title")
	private String title;

	@Column(name = "blog_author")
	private Integer author;

	@Column(name = "blog_snippet")
	private String snippet;

	@Column(name = "blog_detail")
	private String detail;

	@Column(name = "blog_date")
	private Date blogDate = new Date();

	public BlogModel(Long blogId, String title, Integer author, String snippet, String detail, Date blogDate) {
		super();
		this.blogId = blogId;
		this.title = title;
		this.author = author;
		this.snippet = snippet;
		this.detail = detail;
		this.blogDate = blogDate;
	}

	public BlogModel(Long blogId, String title, Integer author, String snippet, String detail) {
		super();
		this.blogId = blogId;
		this.title = title;
		this.author = author;
		this.snippet = snippet;
		this.detail = detail;
	}

	public BlogModel(String title, Integer author, String snippet, String detail) {
		super();
		this.title = title;
		this.author = author;
		this.snippet = snippet;
		this.detail = detail;
	}

	public Date getBlogDate() {
		return blogDate;
	}

	public void setBlogDate(Date blogDate) {
		this.blogDate = blogDate;
	}

	public BlogModel() {
		super();
	}

	public Long getBlogId() {
		return blogId;
	}

	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getAuthor() {
		return author;
	}

	public void setAuthor(Integer author) {
		this.author = author;
	}

	public String getSnippet() {
		return snippet;
	}

	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
