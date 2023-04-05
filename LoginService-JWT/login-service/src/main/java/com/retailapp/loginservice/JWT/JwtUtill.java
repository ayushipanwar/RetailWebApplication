package com.retailapp.loginservice.JWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtill {

	private String secretKey = "RetailApp@E";
	
	public String extractUsername(String token)
	{
		return extractClaims(token,Claims::getSubject);
	} 
	public Date extractExpiration(String token)
	{
		return extractClaims(token,Claims::getExpiration);
	}
	
	public <T> T extractClaims(String token, Function<Claims,T>claimsResolver)
	{
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}
	
	public Claims extractAllClaims(String token)
	{
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
	}
	
	private Boolean isTokenExpired(String token)
	{
		return extractExpiration(token).before(new Date());
	}
	
	//genrating token
	public String generateToken(String userName)
	{
		Map<String, Object>claims = new HashMap<>();
		return createToken(claims,userName);
	}
	
	private String createToken(Map<String,Object>claims, String subject)
	{  
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*60*(1)))
				.signWith(SignatureAlgorithm.HS256,secretKey).compact();
	}
	
	
	
	
	 public Boolean validateToken(String token, UserDetails userDetails)
	 {
		 final String userName = extractUsername(token);
		 
		 return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
	 }

}
