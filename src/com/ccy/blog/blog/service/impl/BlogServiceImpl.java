package com.ccy.blog.blog.service.impl;

import java.util.List;

import com.ccy.blog.blog.Blog;
import com.ccy.blog.blog.dao.BlogDao;
import com.ccy.blog.blog.service.BlogService;
import com.ccy.common.PageBean;


public class BlogServiceImpl implements BlogService{
	
	private BlogDao blogDao;
	
	public Blog findBlogById(Blog blog){
		Blog b =  blogDao.findBlogById(blog);
		return b;
	}
	
	@Override
	public void addBlog(Blog blog) {
		blogDao.addBlog(blog);
	}


	public BlogDao getBlogDao() {
		return blogDao;
	}
	public void setBlogDao(BlogDao blogDao) {
		this.blogDao = blogDao;
	}

	@Override
	public PageBean queryForPage(Object object,  int currentPage,int pageSize) {
		int countPage = 0;
		List<Blog>  list =null;
		int offset  = PageBean.countOffset(pageSize, currentPage);
		if(null!=object){
			countPage = blogDao.getAllRowCount((Blog)object);
			list = blogDao.blogList((Blog)object,offset,pageSize);
		}else{
			countPage = blogDao.getAllRowCount(null);
			list = blogDao.blogList(null, offset,pageSize);
		}
		//把分页信息保存到Bean中 
		PageBean pageBean = new PageBean(); 
		pageBean.setPageSize(pageSize); 
		pageBean.setCurrentPage(currentPage); 
		pageBean.setAllRow(countPage); 
		pageBean.setTotalPage(PageBean.countTotalPage(pageSize,countPage)); 
		pageBean.setList(list); 
		pageBean.init(); 
		return pageBean; 
	}
}	
