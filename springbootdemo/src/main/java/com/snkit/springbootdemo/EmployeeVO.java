package com.snkit.springbootdemo;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EmployeeVO {
	
	int i = 10;
	public EmployeeVO(){
		
	}
	
	@DemoLongValidator(message="Please enter valid employee id"
			,expression="[0-9]*",size=5)
	private Long id;
	
	
	@DemoLongValidator(expression="[0-9]*",size=9)
	private Long code;
	
	
	
	
	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public EmployeeVO(String name) {
		this.name = name;
	}
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	@Pattern(regexp="[a-zA-Z]{15,20}",message="Please enter valid name")	
	private String name;
	
	private String email;
	
	@Size(min=2,max=3,message="Country code value can betwen 2 and 3 charcter")
	private String country;
	
	private String city;
	
	private String state;
	
	private String cmp;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCmp() {
		return cmp;
	}

	public void setCmp(String cmp) {
		this.cmp = cmp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	

}
