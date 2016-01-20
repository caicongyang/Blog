package com.ccy.common.log.service;

import com.ccy.common.log.Log;
import com.ccy.common.user.User;

public interface LogService {
	/**
	 * 记录日志
	 */
	public void log(Log log);
	
	/**
	 * 获取当前登录用户的名称
	 * @return
	 */
	public User getLoginUserName();
	
	/**
	 * 获取当前登录用户的IP
	 * @return
	 */
	public String getLoginUserIP();
}
