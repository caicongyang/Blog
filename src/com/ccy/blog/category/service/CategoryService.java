package com.ccy.blog.category.service;

import java.util.List;

import com.ccy.blog.category.Category;

public interface CategoryService {

	public List<Category> categoryList();
	public void addCategory(Category category);
	public void delCategory(Category category);
	public void updateCategory(Category category);
	public Category findCategory(Object object);

}
