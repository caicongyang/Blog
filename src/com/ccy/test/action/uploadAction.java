package com.ccy.test.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.ccy.common.BaseAtion;

public class uploadAction extends BaseAtion{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username; 
	private File file;
	private String fileFileName;
	private String fileContentType;
	
	
	
	public String upload() throws Exception{
		String root = this.request.getSession().getServletContext().getRealPath("/upload");
		System.out.println("path: " + file.getAbsolutePath());
		
		System.out.println("file: " + file.getName());
		
		System.out.println("fileFileName: " + fileFileName);
		InputStream input = new FileInputStream(file);
		System.out.println("root:"+root);
		File destFile = new File(root,fileFileName);
		OutputStream out = new FileOutputStream(destFile);
		byte[] buffer = new byte[1024];
		int length=0;
		
		if(-1!=(length = input.read(buffer))){
			out.write(buffer, 0, length);
		}
		out.flush();
		out.close();
		input.close();
		return SUCCESS;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	
	

}
