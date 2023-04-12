package com.productcatlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.productcatlog.pojo.UserRegistration;
import com.productcatlog.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public UserRegistration createUser(@RequestBody UserRegistration user) throws Exception
	{
		return this.userService.createUser(user);
	}
	
	@GetMapping("/{username}")
	public UserRegistration getUser(@PathVariable("username") String username)
	{
		return this.userService.getUser(username);
		
	}

}
