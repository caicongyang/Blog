package com.ccy.common;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @function 登录拦截器
 * @author Tom.Cai
 *
 */
public class SsoLoginIntercePtor extends AbstractInterceptor {

	/**
	 * UID
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		ActionContext ctx = ActionContext.getContext();
		Map<String, Object> session = ctx.getSession();
		if(null == session.get("Tom'blog-user")){
			return "login";
		}
		return actionInvocation.invoke();
	}
}
