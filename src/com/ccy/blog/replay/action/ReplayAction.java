package com.ccy.blog.replay.action;

import java.io.IOException;

import com.ccy.blog.blog.Blog;
import com.ccy.blog.replay.Replay;
import com.ccy.blog.replay.service.ReplayService;
import com.ccy.common.BaseAtion;

public class ReplayAction extends BaseAtion {
	private ReplayService replayService;
	private Replay replay;
	private Blog blog;
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 3582609547256181791L;
	
	public void addReplay() {
		replay.setBlog(blog);
		replayService.addReplay(replay);
		this.response.setCharacterEncoding("UTF-8");
		this.response.setContentType("application/json;charset=utf-8");
		try {
			response.getWriter().append("1");
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ReplayService getReplayService() {
		return replayService;
	}

	public void setReplayService(ReplayService replayService) {
		this.replayService = replayService;
	}

	public Replay getReplay() {
		return replay;
	}

	public void setReplay(Replay replay) {
		this.replay = replay;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	
	
	
}
