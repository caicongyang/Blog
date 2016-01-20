package com.ccy.blog.blog.service;

import com.ccy.blog.blog.Blog;
import com.ccy.common.PageBean;

public interface BlogService {
	public Blog findBlogById(Blog blog);

	
	public void addBlog(Blog blog);


	public PageBean queryForPage(Object object, int pageSize, int currentPage);

}
