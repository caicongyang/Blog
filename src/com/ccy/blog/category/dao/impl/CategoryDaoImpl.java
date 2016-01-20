package com.ccy.blog.category.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ccy.blog.category.Category;
import com.ccy.blog.category.dao.CategoryDao;

public class CategoryDaoImpl extends HibernateDaoSupport implements CategoryDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> categoryList() {
		String hql="from Category order by id desc";
		return (List<Category>) this.getHibernateTemplate().find(hql);
	}

	@Override
	public void categoryAdd(Category category) {
		this.getHibernateTemplate().save(category);
	}

	@Override
	public void categoryDel(Category category) {
		this.getHibernateTemplate().delete(category);
	}

	@Override
	public void categoryUpdate(Category category) {
		this.getHibernateTemplate().update(category);
	}

	@Override
	public Category findCategoryById(Integer value) {
		return this.getHibernateTemplate().get(Category.class, value);
		
	}

	@Override
	public Category findCategory(Category category) {
		return this.getHibernateTemplate().get(Category.class, category.getId());
	}
	
	

}
