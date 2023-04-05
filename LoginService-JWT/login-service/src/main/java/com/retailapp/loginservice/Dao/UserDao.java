
package com.retailapp.loginservice.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.retailapp.loginservice.POJO.User;


public interface UserDao extends JpaRepository<User,Integer> {

	User FindByEmail(@Param("email") String email);//implemented by user class
}
