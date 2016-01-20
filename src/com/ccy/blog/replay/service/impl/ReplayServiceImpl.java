package com.ccy.blog.replay.service.impl;

import com.ccy.blog.replay.Replay;
import com.ccy.blog.replay.dao.ReplayDao;
import com.ccy.blog.replay.service.ReplayService;

public class ReplayServiceImpl implements ReplayService {
	
	public ReplayDao replayDao;
	

	@Override
	public void addReplay(Replay replay) {
		replayDao.addReplay(replay);
	}

	public ReplayDao getReplayDao() {
		return replayDao;
	}

	public void setReplayDao(ReplayDao replayDao) {
		this.replayDao = replayDao;
	}
	

}
