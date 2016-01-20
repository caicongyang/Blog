package com.ccy.blog.blog.action;

import java.io.IOException;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.ccy.blog.blog.Blog;
import com.ccy.blog.blog.service.BlogService;
import com.ccy.blog.category.Category;
import com.ccy.blog.category.service.CategoryService;
import com.ccy.common.BaseAtion;
import com.ccy.common.PageBean;

public class BlogAction extends BaseAtion{
	private Blog blog;
	private List<Blog> list;
	private List<Category> clist;
	private CategoryService categoryService;
	private BlogService blogService;
	
	private int currentPage=1;//第几页 
	private PageBean pageBean;//包含分布信息的bean 
	private static int PAGESIZE = 3;
	
	
	private static final long serialVersionUID = -6147003718237679907L;

	public String index(){
		return SUCCESS;
	}
	
	public String main(){
		pageBean = blogService.queryForPage(null,currentPage,PAGESIZE); 
		return SUCCESS;
	}
	
	public String top(){
		return SUCCESS;
	}
	
	public String left(){
		clist = categoryService.categoryList();
		return SUCCESS;
	}
	
	
	public void menu(){
		clist = categoryService.categoryList();
		String json = JSONObject.toJSONString(clist);
		this.response.setCharacterEncoding("UTF-8");
		this.response.setContentType("application/json;charset=utf-8");
		try {
			response.getWriter().append(json);
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String blogDel(){
		clist = categoryService.categoryList();
		blog = blogService.findBlogById(blog);
		return SUCCESS;
	}
	
	public String blogDetail(){
		blog = blogService.findBlogById(blog);
		return SUCCESS;
	}
	
	public String list(){
		if(null!=blog){
			this.request.setAttribute("cagetoryId", blog.getCategory().getId());
		}
		clist = categoryService.categoryList();
		pageBean = blogService.queryForPage(blog,currentPage,PAGESIZE);
		return SUCCESS;
	}
	
	public String blogList(){
		if( 0 == blog.getCategory().getId()){
			pageBean = blogService.queryForPage(null,currentPage,PAGESIZE); 
		}else{
			pageBean = blogService.queryForPage(blog,currentPage,PAGESIZE);
		}
		this.request.setAttribute("cagetoryId", blog.getCategory().getId());
		return SUCCESS;
	}
	
	public String addBlogPage(){
		return SUCCESS;
	}
	
	public String addBlog(){
		blogService.addBlog(blog);
		return SUCCESS; 
	}

	
	

	
	
	
	public BlogService getBlogService() {
		return blogService;
	}

	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public List<Blog> getList() {
		return list;
	}

	public void setList(List<Blog> list) {
		this.list = list;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public List<Category> getClist() {
		return clist;
	}

	public void setClist(List<Category> clist) {
		this.clist = clist;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
}
