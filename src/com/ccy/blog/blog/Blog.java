package com.ccy.blog.blog;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.ccy.blog.category.Category;
import com.ccy.blog.replay.Replay;
import com.ccy.common.user.User;

public class Blog implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7714529053875105126L;
	private int id;
	private String content;
	private String title;
	private String keyWord;
	private User user;
	private Category category;
	private Set<Replay> replays =new HashSet<Replay>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKeyWork() {
		return keyWord;
	}

	public void setKeyWork(String keyWork) {
		this.keyWord = keyWork;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Replay> getReplays() {
		return replays;
	}

	public void setReplays(Set<Replay> replays) {
		this.replays = replays;
	}
}
