package com.retailapp.loginservice.JWT;

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

import io.jsonwebtoken.Claims;

@Component
public class JwtFilter extends OncePerRequestFilter {

	
	@Autowired
	JwtUtill jwtUtill;
	
	@Autowired
	CustomerUserDetailService service;
	
	Claims claims = null;
	private String userName = null;
	
	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain)
			throws ServletException, IOException {
	
		if(httpServletRequest.getServletPath().matches("/user/login|/user/signup"))
		{
		  filterChain.doFilter(httpServletRequest, httpServletResponse);
		}
		else
		{
			String authorizationnHeader = httpServletRequest.getHeader("Authorization");
			String token = null;
			
			if(authorizationnHeader != null && authorizationnHeader.startsWith("Bearer "))
			{
				token = authorizationnHeader.substring(7);
				userName = jwtUtill.extractUsername(token);
				claims = jwtUtill.extractAllClaims(token);
				
			}
			
			//tpinau
			if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null)
			{
				UserDetails userDetails = service.loadUserByUsername(userName);
				if(jwtUtill.validateToken(token, userDetails))
				{
					UsernamePasswordAuthenticationToken userNamePasswordAuthenticationToken = 
							new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
					userNamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
					
					//setting the url
					SecurityContextHolder.getContext().setAuthentication(userNamePasswordAuthenticationToken);
				}
			}
			// after checking all this we let user pass
			filterChain.doFilter(httpServletRequest, httpServletResponse);
		}

	}
	public String getCurrentUser()
	{
		return userName;
	}

}
