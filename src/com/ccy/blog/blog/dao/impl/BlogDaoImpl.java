package com.ccy.blog.blog.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ccy.blog.blog.Blog;
import com.ccy.blog.blog.dao.BlogDao;

public class BlogDaoImpl extends HibernateDaoSupport implements BlogDao {

	@Override
	public Blog findBlogById(Blog blog) {
		return this.getHibernateTemplate().get(Blog.class, blog.getId());
	}
	
	@Override
	public int getAllRowCount(Blog blog){
			String hql = null;
			if(null == blog){
				hql = "from Blog";
				return this.getHibernateTemplate().find(hql).size();
			}else{
				hql = "from Blog b where b.category.id =? ";
				return  this.getHibernateTemplate().find(hql,blog.getCategory().getId()).size();
			}
			
	} 

	@Override
	public List<Blog> blogList(final Blog blog,final int currentPage ,final int pageSize) {
		return this.getHibernateTemplate().executeWithNativeSession(new HibernateCallback<List<Blog>>() {  
            @SuppressWarnings("unchecked")
			public List<Blog> doInHibernate(Session session)  
                    throws HibernateException, SQLException {  
            	String hql = null;
            	Query query  = null ;
            	if(null!=blog){
                	System.out.println(blog.getCategory().getId()+"///");
            		hql = "from Blog b where b.category.id = ? order by id desc";
            		query = session.createQuery(hql); 
            		query.setParameter(0 , blog.getCategory().getId()); 
            	}else{
            		hql="from Blog b order by id desc";
            		query = session.createQuery(hql); 
            	}
                //设置每页显示多少个，设置多大结果。  
                query.setMaxResults(pageSize);  
                //设置起点  
                query.setFirstResult(currentPage);  
                return query.list();  
            }
		});
	}
		
		/*String hql = "from Blog b where b.category.id =? and order by id desc";
		List<Blog> list = (List<Blog>) this.getHibernateTemplate().find(hql,blog.getCategory().getId());
		return list;*/
	

	@Override
	public void addBlog(Blog blog) {
		this.getHibernateTemplate().save(blog);
	}

	
	
	
}
