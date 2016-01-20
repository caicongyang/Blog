package com.ccy.common;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;

import com.ccy.blog.blog.Blog;
import com.ccy.common.log.Log;
import com.ccy.common.log.service.LogService;
import com.ccy.common.user.User;

public class MyLogger {
	
	public LogService logService;
	
	
	public void adminLogger(Object retVal){
		if(null!=retVal){
			User u = (User)retVal;
			Log log = new Log();
			log.setOpname(u.getName());
			log.setOperation("登陆");
			log.setOpdate(new Date());
			log.setOpcontent("用户:"+u.getName()+"登陆成功");
			logService.log(log);
		}
	}
	
	
	public Object opeatorLogger(ProceedingJoinPoint pjp) throws Throwable{
		//proceed()方法有执行目标对象的功能
		Object obj = pjp.proceed();
		//获取方法名
		String method =pjp.getSignature().getName();
		//获取目标对象类名
		//String clazzName = pjp.getTarget().getClass().getName();
		if("addBlog".equals(method)){
			Blog b = (Blog) pjp.getArgs()[0];
			User  u = logService.getLoginUserName();
			Log log = new Log();
			log.setOpname(u.getName());
			log.setOperation("新增文章");
			log.setOpdate(new Date());
			System.out.println(b.getTitle());
			log.setOpcontent("用户："+u.getName()+"发表文章："+b.getTitle());
			logService.log(log);
			System.out.println("执行了opeatorLogger记录日志...");
			return obj;
		}else{
			return obj;
		}
	}
		
		
	

	public LogService getLogService() {
		return logService;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}
	
}
