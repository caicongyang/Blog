package com.ccy.common.login.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ccy.common.login.dao.LoginDao;
import com.ccy.common.user.User;

public class LoginDaoImpl extends HibernateDaoSupport implements LoginDao{

	@Override
	public User findUser(String  name) {
		String hql = "from User where name=?";
		List<?> list   =  this.getHibernateTemplate().find(hql,name);
		if(null!=list && list.size()>0){
			return (User)list.get(0);
		}
		return null;
	}
}
