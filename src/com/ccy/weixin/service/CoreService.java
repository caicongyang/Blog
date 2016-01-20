package com.ccy.weixin.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.ccy.weixin.domain.resp.Article;
import com.ccy.weixin.domain.resp.NewsMsg;
import com.ccy.weixin.domain.resp.TextMsg;
import com.ccy.weixin.util.MessageUtil;

/**
 * 核心服务类
 * 
 * @author Tom.Cai
 * @date 2014-10-08
 */
public class CoreService {

	private static String welcomeMsg = "感谢您关注caicongyang订阅号~\n"
			+ "/::)爱小福州，爱生活，我是您身边的全能好帮手小蔡。关注福州IT圈，关注福州生活圈，有需求您找我,"
			+ "我将动用广阔的人脉圈为您解决在福州生活的各种问题！\n"
			+ "您可以回复数字获取以下服务：\n"
			+ "【0】IT工作机会\n"
			+ "【1】推荐电脑优质卖家\n"
			+ "【2】推荐电脑维修服务\n"
			+ "【3】推荐行水手机卖家\n"
			+ "【4】推荐办理信用卡\n"
			+ "【5】股票投资\n"
			+ "【6】贵金属投资\n"
			+ "【7】每日笑话\n" 
			+ "<a href=\"http://blog.csdn.net/caicongyang\">【8】作者的技术博客\n</a>"
			+ "【9】关于作者\n"
			+ "【10】下载源码\n";
	
	

	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return
	 */
	public static String processRequest(HttpServletRequest request) {
		String respMessage = null;
		try {
			// 默认返回的文本消息内容
			String respContent = "请求处理异常，请稍候尝试！";

			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);

			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");

			// 回复文本消息
			TextMsg textMessage = new TextMsg();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);

			// 文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				String Content = requestMap.get("Content");
				respMessage = textMegProcess(fromUserName,toUserName,Content);
			}
			// 图片消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				respContent = "您发送的是图片消息！";
				textMessage.setContent(respContent);
				respMessage = MessageUtil.textMsgToXml(textMessage);
			}
			// 地理位置消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respContent = "您发送的是地理位置消息！";
				textMessage.setContent(respContent);
				respMessage = MessageUtil.textMsgToXml(textMessage);
			}
			// 链接消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "您发送的是链接消息！";
				textMessage.setContent(respContent);
				respMessage = MessageUtil.textMsgToXml(textMessage);
			}
			// 音频消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				respContent = "您发送的是音频消息！";
				textMessage.setContent(respContent);
				respMessage = MessageUtil.textMsgToXml(textMessage);
			}
			// 事件推送
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// 事件类型
				String eventType = requestMap.get("Event");
				// 订阅
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					respContent = welcomeMsg;
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMsgToXml(textMessage);
				}
				// 取消订阅
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
				}
				// 自定义菜单点击事件
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					// TODO 自定义菜单权没有开放，暂不处理该类消息
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respMessage;
	}

	public static String textMegProcess(String fromUserName,String toUserName,String content) {
		// 文本消息
		TextMsg textMessage = new TextMsg();
		textMessage.setToUserName(fromUserName);
		textMessage.setFromUserName(toUserName);
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
		textMessage.setFuncFlag(0);
		//图文消息
		 NewsMsg newsMessage = new NewsMsg();  
         newsMessage.setToUserName(fromUserName);  
         newsMessage.setFromUserName(toUserName);  
         newsMessage.setCreateTime(new Date().getTime());  
         newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);  
         newsMessage.setFuncFlag(0); 
         
         List<Article> articleList = new ArrayList<Article>();  
		
         String tip = "功能正在开发中，尽情期待！";
         String response = null;
		
		if ("0".equals(content) || "零".equals(content)) {
			textMessage.setContent(tip);;
			response = MessageUtil.textMsgToXml(textMessage);
		} else if ("1".equals(content) || "一".equals(content)) {
			textMessage.setContent(tip);;
			response = MessageUtil.textMsgToXml(textMessage);
		} else if ("2".equals(content) || "二".equals(content)) {
			textMessage.setContent(tip);;
			response = MessageUtil.textMsgToXml(textMessage);
		} else if ("3".equals(content) || "三".equals(content)) {
			textMessage.setContent(tip);;
			response = MessageUtil.textMsgToXml(textMessage);
		} else if ("4".equals(content) || "四".equals(content)) {
			Article article1 = new Article();  
            article1.setTitle("推荐办理招商银行信用卡");  
            article1.setDescription("我们不办理信用卡，我们只是推荐办理，我们不保证能够申请通过，但是我们尽所能竭诚为您服务！");  
            article1.setPicUrl("http://114.215.144.169/caicongyang/img/ccb.jpg");  
            article1.setUrl("http://blog.csdn.net/caicongyang");
            
            Article article2 = new Article();  
            article2.setTitle("推荐交通银行信用卡");  
            article2.setDescription("");  
            article2.setPicUrl("http://114.215.144.169/caicongyang/img/hsbc.jpg");    
            article2.setUrl("http://blog.csdn.net/caicongyang");  


            articleList.add(article1);  
            articleList.add(article2);  
            newsMessage.setArticleCount(articleList.size());  
            newsMessage.setArticles(articleList);  
            response = MessageUtil.newsMsgToXml(newsMessage);  
		} else if ("5".equals(content) || "五".equals(content)) {
			textMessage.setContent(tip);;
			response = MessageUtil.textMsgToXml(textMessage);
		} else if ("6".equals(content) || "六".equals(content)) {
			textMessage.setContent(tip);;
			response = MessageUtil.textMsgToXml(textMessage);
		} else if ("7".equals(content) || "七".equals(content)) {
			textMessage.setContent(tip);;
			response = MessageUtil.textMsgToXml(textMessage);
		} else if ("8".equals(content) || "八".equals(content)) {
			textMessage.setContent(tip);;
			response = MessageUtil.textMsgToXml(textMessage);
		} else if ("9".equals(content) || "九".equals(content)) {
			// 创建图文消息  
			Article article = new Article();  
            article.setTitle("Cai Congyang"); 
            article.setDescription("caicongyang，90后程序员，专注于企业计算、整体解决方案、互联网和大数据方向!");  
            article.setPicUrl("http://114.215.144.169/caicongyang/img/ccy.jpg");  
            article.setUrl("http://114.215.144.169/caicongyang/index.html");  
            articleList.add(article);  
            // 设置图文消息个数  
            newsMessage.setArticleCount(articleList.size());  
            // 设置图文消息包含的图文集合  
            newsMessage.setArticles(articleList);  
            // 将图文消息对象转换成xml字符串  
            response = MessageUtil.newsMsgToXml(newsMessage);
		} else if ("10".equals(content) || "十".equals(content)) {
			// 创建图文消息  
			Article article = new Article();  
            article.setTitle("源码下载"); 
            article.setDescription("作者：caicongyang，90后，这是一个微信项目同时包含博客的功能，可以作为工程师推广自己的工具！");  
            article.setPicUrl("http://114.215.144.169/caicongyang/img/ccy.jpg");  
            article.setUrl("http://blog.csdn.net/caicongyang");  
            articleList.add(article);  
            // 设置图文消息个数  
            newsMessage.setArticleCount(articleList.size());  
            // 设置图文消息包含的图文集合  
            newsMessage.setArticles(articleList);  
            // 将图文消息对象转换成xml字符串  
            response = MessageUtil.newsMsgToXml(newsMessage);
		} else{
			String menu = "/::)关注福州生活圈，有需求您找我，我是您身边的全能好帮手小蔡！\n"
			+ "回复数字获取以下 服务：\n"
			+ "【0】IT工作机会\n"
			+ "【1】推荐电脑优质卖家\n"
			+ "【2】推荐电脑维修服务\n"
			+ "【3】推荐行水手机卖家\n"
			+ "【4】推荐办理信用卡\n"
			+ "【5】股票投资\n"
			+ "【6】贵金属投资\n"
			+ "【7】贵金属投资\n"
			+ "【8】每日笑话\n" 
			+ "<a href=\"http://blog.csdn.net/caicongyang\">【9】作者的技术博客\n</a>"
			+ "【10】关于作者\n"
			+ "【11】下载源码\n";
			textMessage.setContent(menu);;
			response = MessageUtil.textMsgToXml(textMessage);
		}
		return response;
	}
}