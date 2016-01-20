package com.ccy.blog.category.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.ccy.blog.category.Category;
import com.ccy.blog.category.service.CategoryService;
import com.ccy.common.BaseAtion;

public class CategoryAction extends BaseAtion{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CategoryService categoryService;
	private List<Category> list;
	private Category category;
	
	/**
	 * json获取文章列表
	 */
	public void categoryList(){
		list = categoryService.categoryList();
		String json = JSON.toJSONString(list);
		HttpServletResponse reponse = this.response;
		reponse.setCharacterEncoding("UTF-8");
		reponse.setContentType("application/json;charset=utf-8");
		try {
			reponse.getWriter().append(json);
			reponse.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String list(){
		list = categoryService.categoryList();
		return SUCCESS;
	}
	
	/**
	 * 增加文章分类列表页面
	 * @return
	 */
	public String addPage(){
		return SUCCESS;
	}
	
	public String add(){
		categoryService.addCategory(category);
		return SUCCESS;
	}
	

	public String updatePage(){
		category = categoryService.findCategory(category.getId());
		return SUCCESS;
	}
	
	public String update(){
		categoryService.updateCategory(category);
		return SUCCESS;
	}
	
	public String del(){
		categoryService.delCategory(category);
		return SUCCESS;
	}
	
	
	public CategoryService getCategoryService() {
		return categoryService;
	}

	

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}


	public List<Category> getList() {
		return list;
	}


	public void setList(List<Category> list) {
		this.list = list;
	}




	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}

	
	
}
