package com.ccy.blog.replay.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ccy.blog.replay.Replay;
import com.ccy.blog.replay.dao.ReplayDao;

public class ReplayDaoImpl extends HibernateDaoSupport implements ReplayDao{

	@Override
	public void addReplay(Replay replay) {
		this.getHibernateTemplate().save(replay);
	}

}
