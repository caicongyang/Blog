package com.ccy.common.log.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ccy.common.log.Log;
import com.ccy.common.log.dao.LogDao;

public class LogDaoImpl extends HibernateDaoSupport implements LogDao {

	@Override
	public void log(Log log) {
		this.getHibernateTemplate().persist(log);
	}

}
