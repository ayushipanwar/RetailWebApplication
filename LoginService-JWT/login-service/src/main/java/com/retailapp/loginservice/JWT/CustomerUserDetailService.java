package com.retailapp.loginservice.JWT;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.retailapp.loginservice.Dao.UserDao;

@Service
public class CustomerUserDetailService implements UserDetailsService {

	@Autowired
	UserDao userDao;
	
	private com.retailapp.loginservice.POJO.User userDetail;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		userDetail = userDao.FindByEmail(username);
		System.out.println("Inside loadUserByUsername"+ username);
		if(!Objects.isNull(userDetail))
		{
		return new User(userDetail.getEmail(),userDetail.getPassword(), new ArrayList<>());
		}
		else
		{
			throw new UsernameNotFoundException("user not found");
		}
	}
	
	public com.retailapp.loginservice.POJO.User getUserDetails()
	{
		return userDetail;
	}
	

}
