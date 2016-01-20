package com.ccy.test.action;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6429938232806559076L;
	
	private String username;
	private Date birthday; 

	

	public String 	myExecute() throws Exception {
		
		return SUCCESS;
	}
	
	public void validateMyExecute() {
		System.out.println("validateMyExecute() is running...");
	}

	

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	@Override
	public void validate() {
		System.out.println("validate() is running...");
	}




	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public Date getBirthday() {
		return birthday;
	}



	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
	
	
	
	
	

}
