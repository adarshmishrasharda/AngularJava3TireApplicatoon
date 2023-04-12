package com.productcatlog.UserServiceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcatlog.pojo.UserRegistration;
import com.productcatlog.repository.UserRepository;
import com.productcatlog.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserRegistration createUser(UserRegistration user) throws Exception {
		// TODO Auto-generated method stub
		
		UserRegistration localuser=this.userRepository.findByUsername(user.getUsername());
		
		if(localuser!=null)
		{
			System.out.println("user already exist");
			throw new Exception("user al ready present with given username");
		}
		else
		{
			localuser=this.userRepository.save(user);
		}
		
		
		return localuser;
	}

	@Override
	public UserRegistration getUser(String username) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUsername(username);
	}

}
