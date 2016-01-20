package com.ccy.weixin.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.ccy.weixin.domain.resp.Article;
import com.ccy.weixin.domain.resp.MusicMsg;
import com.ccy.weixin.domain.resp.NewsMsg;
import com.ccy.weixin.domain.resp.TextMsg;

public class MessageUtil {
	/** 
     * 返回消息类型：文本 
     */  
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";  
  
    /** 
     * 返回消息类型：音乐 
     */  
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";  
  
    /** 
     * 返回消息类型：图文 
     */  
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";  
  
    /** 
     * 请求消息类型：文本 
     */  
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";  
  
    /** 
     * 请求消息类型：图片 
     */  
    public static final String REQ_MESSAGE_TYPE_IMAGE = "image";  
  
    /** 
     * 请求消息类型：链接 
     */  
    public static final String REQ_MESSAGE_TYPE_LINK = "link";  
  
    /** 
     * 请求消息类型：地理位置 
     */  
    public static final String REQ_MESSAGE_TYPE_LOCATION = "location";  
  
    /** 
     * 请求消息类型：音频 
     */  
    public static final String REQ_MESSAGE_TYPE_VOICE = "voice";  
  
    /** 
     * 请求消息类型：推送 
     */  
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";  
  
    /** 
     * 事件类型：subscribe(订阅) 
     */  
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";  
  
    /** 
     * 事件类型：unsubscribe(取消订阅) 
     */  
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";  
  
    /** 
     * 事件类型：CLICK(自定义菜单点击事件) 
     */  
    public static final String EVENT_TYPE_CLICK = "CLICK";  
    
    
    /** 
     * 解析微信发来的请求（XML） 
     *  
     * @param request 
     * @return 
     * @throws Exception 
     */  
    @SuppressWarnings("unchecked")  
    public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {  
        // 将解析结果存储在HashMap中  
        Map<String, String> map = new HashMap<String, String>();  
  
        // 从request中取得输入流  
        InputStream inputStream = request.getInputStream();  
        // 读取输入流  
        SAXReader reader = new SAXReader();  
        Document document = reader.read(inputStream);  
        // 得到xml根元素  
        Element root = document.getRootElement();  
        // 得到根元素的所有子节点  
        List<Element> elementList = root.elements();  
  
        // 遍历所有子节点  
        for (Element e : elementList)  
            map.put(e.getName(), e.getText());  
  
        // 释放资源  
        inputStream.close();  
        inputStream = null;  
        return map;  
    }  
    
    public static String textMsgToXml(TextMsg textMsg) { 
    	Document document = DocumentHelper.createDocument();
    	Element root = document.addElement("xml");
    	Element ToUserNameElement = root.addElement("ToUserName");
    	ToUserNameElement.addText(textMsg.getToUserName());
    	Element FromUserNameElement = root.addElement("FromUserName");
    	FromUserNameElement.addText(textMsg.getFromUserName());
    	Element CreateTimeElement = root.addElement("CreateTime");
    	CreateTimeElement.addText(String.valueOf(textMsg.getCreateTime()));
    	Element MsgTypeElement = root.addElement("MsgType");
    	MsgTypeElement.setText(textMsg.getMsgType());
    	Element ContentElement = root.addElement("Content");
    	ContentElement.setText(textMsg.getContent());
    	return document.asXML();
    } 
  
    /** 
     * 音乐消息对象转换成xml 
     *  
     * @param musicMessage 音乐消息对象 
     * @return xml 
     */  
    public static String musicMsgToXml(MusicMsg musicMsg) { 
    	 
    	return null;
    }  
  
    /** 
     * 图文消息对象转换成xml 
     *  
     * @param newsMessage 图文消息对象 
     * @return xml 
     */  
    public static String newsMsgToXml(NewsMsg newsMsg) {  
    	Document document = DocumentHelper.createDocument();
    	Element root = document.addElement("xml");
    	Element ToUserNameElement = root.addElement("ToUserName");
    	ToUserNameElement.addText(newsMsg.getToUserName());
    	Element FromUserNameElement = root.addElement("FromUserName");
    	FromUserNameElement.addText(newsMsg.getFromUserName());
    	Element CreateTimeElement = root.addElement("CreateTime");
    	CreateTimeElement.addText(String.valueOf(newsMsg.getCreateTime()));
    	Element MsgTypeElement = root.addElement("MsgType");
    	MsgTypeElement.setText(newsMsg.getMsgType());
    	Element ArticleCountElement = root.addElement("ArticleCount");
    	int count = newsMsg.getArticles().size();
    	ArticleCountElement.setText(String.valueOf(count));
    	Element ArticlesElement = root.addElement("Articles");
    	for(int i = 0;i<count;i++){
    		Article article = newsMsg.getArticles().get(i);
    		Element itemElement = ArticlesElement.addElement("item");
    		Element TitleElement = itemElement.addElement("Title");
    		TitleElement.setText(article.getTitle());
    		Element DescriptionElement = itemElement.addElement("Description");
    		Element PicUrlElement = itemElement.addElement("PicUrl");
    		Element UrlElement = itemElement.addElement("Url");
    		DescriptionElement.setText(article.getDescription());
    		PicUrlElement.setText(article.getPicUrl());
    		UrlElement.setText(article.getUrl());
    	}
    	return document.asXML();
    }  
    
}
