package com.ccy.blog.category.dao;

import java.util.List;

import com.ccy.blog.category.Category;

public interface CategoryDao {

	public List<Category> categoryList();

	public void categoryAdd(Category category);
	
	public void categoryDel(Category category);
	
	public void categoryUpdate(Category category);

	public Category findCategoryById(Integer value);

	public Category findCategory(Category category);

}
