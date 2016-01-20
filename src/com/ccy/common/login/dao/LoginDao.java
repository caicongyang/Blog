package com.ccy.common.login.dao;

import com.ccy.common.user.User;

public interface LoginDao {

	public User findUser(String name);

}
