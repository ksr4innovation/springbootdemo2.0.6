package com.snkit.springbootdemo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(schema="microservice" ,name="user")
public class UserEntity implements Serializable {
	
	public UserEntity() {
		
	}
	
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="name")
	private String name;
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", email=" + email + ", name=" + name + "]";
	}
	
	

}
