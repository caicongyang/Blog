package com.ccy.blog.blog.dao;

import java.util.List;

import com.ccy.blog.blog.Blog;

public interface BlogDao {

	public Blog findBlogById(Blog blog);

	public int getAllRowCount(Blog blog);
	
	public List<Blog> blogList(Blog blog,int currentPage, int pageSize);

	public void addBlog(Blog blog);

}
