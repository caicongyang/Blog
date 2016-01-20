package com.ccy.blog.category.service.impl;

import java.util.List;

import com.ccy.blog.category.Category;
import com.ccy.blog.category.dao.CategoryDao;
import com.ccy.blog.category.service.CategoryService;

public class CategoryServiceImpl implements CategoryService{
	private CategoryDao categoryDao;

	@Override
	public List<Category> categoryList() {
		return categoryDao.categoryList();
	}

	@Override
	public void addCategory(Category category) {
		 categoryDao.categoryAdd(category);
	}

	@Override
	public void delCategory(Category category) {
		categoryDao.categoryDel(category);
	}

	@Override
	public void updateCategory(Category category) {
		categoryDao.categoryUpdate(category);
	}
	
	
	@Override
	public Category findCategory(Object obj) {
		if((Category.class).equals(obj.getClass())){
			return categoryDao.findCategory((Category)obj);
		}else{
			return categoryDao.findCategoryById((Integer)obj);
		}
	}
	
	
	
	
	
	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	
}
