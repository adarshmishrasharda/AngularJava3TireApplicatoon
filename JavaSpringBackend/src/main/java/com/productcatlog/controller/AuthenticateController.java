package com.productcatlog.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productcatlog.config.JwtUtil;
import com.productcatlog.pojo.JwtRequest;
import com.productcatlog.pojo.JwtResponse;
import com.productcatlog.pojo.UserRegistration;

@RestController
@CrossOrigin("*")
public class AuthenticateController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;

	
	@Autowired
	private JwtUtil jwtUtils;
	
	
	
	
	//generate token
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception
	{
		try {
			
			authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
			
		}catch(UsernameNotFoundException e)
		{
			e.printStackTrace();
			throw new Exception("user not found");
		}
		
		///user authentixated
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
		System.out.println("user details is"+userDetails);
		String tokenget = this.jwtUtils.generateToken(userDetails);
		System.out.println("user details is"+tokenget);
	
		return ResponseEntity.ok(new JwtResponse(tokenget));
		
	
	}
	
	
	
	
	
	
	
	private void authenticate(String username, String password) throws Exception {
		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
		}
		
		
		catch(DisabledException e)
		{
			throw new Exception("user Disabled");
		}catch(BadCredentialsException e)
		{
			throw new Exception("invalid credential"+ e.getMessage());
		}
	}
	
	
	//return current user details
	@GetMapping("/current-user")
	public UserRegistration getCurrentUser(Principal principal)
	{
		return ((UserRegistration)this.userDetailsService.loadUserByUsername(principal.getName()));
		
	}
	
	
}
