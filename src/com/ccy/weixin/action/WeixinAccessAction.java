package com.ccy.weixin.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import com.ccy.common.BaseAtion;
import com.ccy.util.HashKit;
import com.ccy.weixin.service.CoreService;

/**
 * 微信接入
 * 
 * @author hp
 * 
 */
public class WeixinAccessAction extends BaseAtion {
	protected Logger logger = Logger.getLogger(WeixinAccessAction.class);

	private static final String TOKEN = "caicongyang";

	private String signature;
	private String timestamp;
	private String nonce;
	private String echostr;

	public void weixinAccess() {
		try {
			this.request.setCharacterEncoding("UTF-8");
			this.response.setCharacterEncoding("UTF-8");
			logger.info(this.request.getCharacterEncoding());
			logger.info(this.response.getCharacterEncoding());
			System.out.println(this.response.getCharacterEncoding());
			String method = this.request.getMethod();
			if ("GET".equals(method)) {
				if (null != timestamp && null != nonce && null != echostr
						&& null != signature) {
					if (access(TOKEN, signature, timestamp, nonce)) {
						this.response.getWriter().write(echostr);
						this.response.getWriter().flush();
					}
				}
			} else {
				// 调用核心业务类接收消息、处理消息
				String respMessage = CoreService.processRequest(request);
				// 响应消息
				PrintWriter out = response.getWriter();
				out.print(respMessage);
				out.close();
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}
	}

	public static boolean access(String token, String signature,
			String timestamp, String nonce) {
		List<String> list = new ArrayList<String>();
		list.add(timestamp);
		list.add(nonce);
		list.add(token);
		Collections.sort(list);
		StringBuilder builder = new StringBuilder();
		for (String s : list) {
			builder.append(s);
		}
		return signature.equalsIgnoreCase(HashKit.sha1(builder.toString()));
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getNonce() {
		return nonce;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	public String getEchostr() {
		return echostr;
	}

	public void setEchostr(String echostr) {
		this.echostr = echostr;
	}

}
