package com.ccy.common.login.action;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;

import com.ccy.common.BaseAtion;
import com.ccy.common.login.service.LoginService;
import com.ccy.common.user.User;

public class LoginAction extends BaseAtion {

	private static final long serialVersionUID = -1316299714289463579L;

	private User user;
	private LoginService loginService;
	private boolean useCookie;
	private static final String SESSION_NAME="Tom'blog-user";

	public String login() throws Exception {
		User u = loginService.findUser(user);
		if (null != u) {
			this.session.put(SESSION_NAME, user);
			//增加cookie
			if(useCookie){
				Cookie cookie =new Cookie(SESSION_NAME, URLEncoder.encode(user.getName(), "UTF-8"));
				cookie.setMaxAge(60*60*24*7);
				cookie.setPath(request.getContextPath());
				this.response.addCookie(cookie);
			}
			return SUCCESS;
		} else {
			this.addActionError("用户名密码不正确！");
			return INPUT;
		}
	}
	
	
	
	public String logout(){
		String value = (String) this.session.get(SESSION_NAME);
		if(null != value && !"".equals(value)){
			this.session.put(SESSION_NAME, null);
			//删除cookie
			Cookie[] cookies = request.getCookies();  
	        if (cookies != null) {  
	            for (Cookie cookie : cookies) {  
	                if (SESSION_NAME.equals(cookie.getName())) {  
	                    cookie.setValue(""); 
	                	cookie.setPath(request.getContextPath());
	                    cookie.setMaxAge(0);
	                    response.addCookie(cookie);
	                }  
	            }  
	        }
		}
		return INPUT;
	}

	public String loginPage() throws Exception {
		return INPUT;
	}

	@Override
	public void validate() {
		super.validate();
	}
	
	
	
	
	
	
	

	public boolean isUseCookie() {
		return useCookie;
	}



	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}



	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

}
