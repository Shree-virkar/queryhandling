package com.cdac.dao;

import com.cdac.model.Login;

public interface LoginDao{

	Login userLogin(Login user);
	
	Login getUserId(String userName,String password);
	
}
