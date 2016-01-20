package com.ccy.common.log;

import java.io.Serializable;
import java.util.Date;

public class Log implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1035954763864372845L;
	private int id;//管理员id  
	private String opname;//
    private Date opdate;//日期  
    private String opcontent;//日志内容  
    private String operation;//操作(主要是"添加"、"修改"、"删除")  
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOpname() {
		return opname;
	}
	public void setOpname(String opname) {
		this.opname = opname;
	}
	public Date getOpdate() {
		return opdate;
	}
	public void setOpdate(Date opdate) {
		this.opdate = opdate;
	}
	public String getOpcontent() {
		return opcontent;
	}
	public void setOpcontent(String opcontent) {
		this.opcontent = opcontent;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
    
    
}
