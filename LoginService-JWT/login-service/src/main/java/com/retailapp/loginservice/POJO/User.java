package com.retailapp.loginservice.POJO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQuery(name = "User.FindByEmail", query= "select u from User u where u.email =:email")
@Entity
@Table(name ="user")
public class User implements Serializable{
	
	private static final  long serialVersionUID = 1L;
	@Id
	@Column(name ="id")
	private Integer id;
	
	@Column(name ="name")
	private String name;
	
	@Column(name ="contactNumber")
	private String contactNumber;
	
	@Column(name ="email")
	private String email;
	
	@Column(name ="password")
	private String password;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}


	

	
	
	
}
