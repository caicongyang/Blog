package com.ccy.common.login.service.impl;

import com.ccy.common.login.dao.LoginDao;
import com.ccy.common.login.service.LoginService;
import com.ccy.common.user.User;

public class LoginServerImpl implements LoginService{ 
	private LoginDao loginDao;

	@Override
	public User findUser(User user) {
		User u = loginDao.findUser(user.getName());
		if(null != u && u.getPassword()!=null ){
			if(u.getPassword().equals(user.getPassword())){
				return u;
			}
		}else{
			return null;
		}
		return null;
	}

	
	
	
	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
}
