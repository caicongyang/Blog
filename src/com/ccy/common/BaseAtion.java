package com.ccy.common;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.CookiesAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAtion extends ActionSupport implements SessionAware, CookiesAware,ServletRequestAware,
		ServletResponseAware, ServletContextAware {

	private static final long serialVersionUID = 1L;
	protected Map<String, Object> session;
	protected  Map<String, String> cookie;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected ServletContext context;
	private Map<String, String> params = new HashMap<String, String>();
	

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;

	}

	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;

	}

	@Override
	public void setCookiesMap(Map<String, String> cookie) {
		this.cookie = cookie;
	}
	
	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}


}
