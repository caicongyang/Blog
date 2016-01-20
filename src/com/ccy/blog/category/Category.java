package com.ccy.blog.category;

import java.util.HashSet;
import java.util.Set;


import com.ccy.blog.blog.Blog;

public class Category {
	private int id;
	private String name;
	private String description;
	private Set<Blog> blogs = new HashSet<Blog>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Blog> getBlogs() {
		return blogs;
	}
	public void setBlogs(Set<Blog> blogs) {
		this.blogs = blogs;
	}
	
	

}
