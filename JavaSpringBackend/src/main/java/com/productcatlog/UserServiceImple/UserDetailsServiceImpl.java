package com.productcatlog.UserServiceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.productcatlog.pojo.UserRegistration;
import com.productcatlog.repository.UserRepository;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		UserRegistration user=this.userRepository.findByUsername(username);
		
		
		if(user==null)
		{
			System.out.println("user not found");
			throw new UsernameNotFoundException("no user found");
		}
		
		
		return user;
	}

}
