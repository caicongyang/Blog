package com.ccy.common.log.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ccy.common.log.Log;
import com.ccy.common.log.dao.LogDao;
import com.ccy.common.log.service.LogService;
import com.ccy.common.user.User;

public class LogServiceImpl implements LogService{
	private LogDao logDao;
	
	
	@Override
	public void log(Log log) {
		logDao.log(log);
	}

	@Override
	public User getLoginUserName() {
		HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
		User user = (User) session.getAttribute("Tom'blog-user");
		return user;
	}
	
	@Override
	public String getLoginUserIP() {
		HttpServletRequest  request =  ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return request.getRemoteHost();
	}

	public LogDao getLogDao() {
		return logDao;
	}

	public void setLogDao(LogDao logDao) {
		this.logDao = logDao;
	}
}
