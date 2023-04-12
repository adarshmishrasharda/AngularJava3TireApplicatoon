package com.productcatlog.services;


import com.productcatlog.pojo.UserRegistration;
;

public interface UserService {
	
	
	//create user
	public UserRegistration createUser(UserRegistration user) throws Exception;
	
	
	//get user by user name
	
	public UserRegistration getUser(String username);
		


}
