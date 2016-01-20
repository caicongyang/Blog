package com.ccy.util.converter;

import java.util.Map;
import java.util.StringTokenizer;

import com.ccy.test.User;
import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

public class UserConverter extends  DefaultTypeConverter{

	@Override
	public Object convertValue(Map<String, Object> context, Object value, Class toType) {
		if(	User.class == toType){
			String[] str = (String[])value;
			String firstVlue = str[0];
			StringTokenizer st = new StringTokenizer(firstVlue,";");
			String username = st.nextToken();
			String password = st.nextToken();
			
			User u = new User();
			u.setUsername(username);
			u.setPassword(password);
			return u;
		}else if(String.class ==  toType){
			User u = (User)value;
			return u.getUsername()+";"+u.getPassword();
		}
		return null;
	}

	

	
	
}
