package com.ccy.common.index.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.ccy.common.BaseAtion;

public class IndexAction extends BaseAtion {

	
	private static final long serialVersionUID = 5015071705219651224L;

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String agent = request.getHeader("User-Agent");
		if (agent != null
				&& ((agent.toLowerCase().indexOf("linux") != -1 && agent
						.toLowerCase().indexOf("mobile") != -1) || (agent
						.toLowerCase().indexOf("linux") != -1 && agent
						.toLowerCase().indexOf("build") != -1))) {
			if (agent.toLowerCase().indexOf("linux") == -1) {
				// 2345浏览器、（冲浪浏览器）
				if (agent.toLowerCase().indexOf("mb2345browser") > 0
						|| agent.toLowerCase().indexOf("safari") > 0) {
					return "phone";
				} else {
					// response.sendRedirect(request.getContextPath()+"/phone.html");
					return "phone";
				}
			}
			// 欧鹏
			else if (agent.toLowerCase().indexOf("android") > 0
					&& agent.toLowerCase().indexOf("presto") > 0) {
				return "phone";
			}
			// 3G浏览器
			else if (agent.toLowerCase().indexOf("linux") > 0
					&& agent.toLowerCase().indexOf("explorer") > 0) {
				return "phone";
			}
			// 三星自带浏览器
			else if (agent.toLowerCase().indexOf("android") > 0
					&& agent.toLowerCase().indexOf("browser") > 0) {
				return "phone";
			}
			// iphone手机
			else if ((agent.toLowerCase().indexOf("ios") > 0 && agent
					.toLowerCase().indexOf("iph") > 0)
					|| agent != null
					&& (agent.toLowerCase().indexOf("os") > 0 && agent
							.toLowerCase().indexOf("iphone") > 0)) {
				return "phone";
			}
		} else {
			return SUCCESS;
		}
		return SUCCESS;
	}
}
