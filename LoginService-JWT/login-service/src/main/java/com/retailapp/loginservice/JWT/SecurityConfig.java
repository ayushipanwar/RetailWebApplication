package com.retailapp.loginservice.JWT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
@Autowired
CustomerUserDetailService customerUserDetailsService ;

@Autowired(required  =true)
JwtFilter jwtFilter;

@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception
{
	auth.userDetailsService(customerUserDetailsService);
}

@Bean
public PasswordEncoder passwordEncoder()
{
	return NoOpPasswordEncoder.getInstance();
}

@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
@Override
public AuthenticationManager authenticationManagerBean() throws Exception {
	// TODO Auto-generated method  tub
	return super.authenticationManagerBean();
}


@Override
protected void configure(HttpSecurity http) throws Exception {
	http.cors().configurationSource(Request -> new CorsConfiguration().applyPermitDefaultValues())
	.and()
	.csrf().disable()//we donot need this as it is just for local user .
	.authorizeRequests()
	.antMatchers("/user/login", "/user/signup")
	.permitAll()
	.anyRequest()
	.authenticated()
	.and()
	.sessionManagement()
	.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	
	http.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
}

}
