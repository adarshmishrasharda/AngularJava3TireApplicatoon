package com.productcatlog.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.productcatlog.UserServiceImple.UserDetailsServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;



@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	
	
	@Autowired
	private JwtUtil jwtUtil;
	

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		final String requestTokenHander = request.getHeader("Authorization");
		System.out.println(requestTokenHander);
		
		String username=null;
		String jwtToken =null;
		
		if(requestTokenHander!=null && requestTokenHander.startsWith("Bearer"))
		{
			//yes token vaild
			jwtToken=requestTokenHander.substring(7);
			
			try {
			username=this.jwtUtil.extractUsername(jwtToken);
			}
			catch(ExpiredJwtException e){
				System.out.println("jwt token expired");
				
			}catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("error");
			}
		}
		else
		{
			System.out.println("Invalid token , not start with bearer");
			
		}
				
		
		//validate token
		
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			final UserDetails userDetails = this.userDetailsServiceImpl.loadUserByUsername(username);
		
			if(this.jwtUtil.validateToken(jwtToken, userDetails))
			{
				//token is valid
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				
			}
			else
			{
				System.out.println("token is not valid");
			}
		
		}
		
		
		filterChain.doFilter(request, response);
		
		
		
	}

}
