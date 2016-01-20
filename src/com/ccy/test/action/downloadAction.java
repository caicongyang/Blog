package com.ccy.test.action;

import java.io.InputStream;

import com.ccy.common.BaseAtion;

public class downloadAction extends BaseAtion{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String filename;

	public String getFilename()
	{
		return filename;
	}

	public void setFilename(String filename)
	{
		this.filename = filename;
	}
	
	
	public InputStream getDownloadFile()
	{
		this.filename = "test.txt";
		return this.request.getSession().getServletContext().getResourceAsStream("/upload/test.txt");
	}

	@Override
	public String execute() throws Exception
	{
		return SUCCESS;
	}
	
	

}
