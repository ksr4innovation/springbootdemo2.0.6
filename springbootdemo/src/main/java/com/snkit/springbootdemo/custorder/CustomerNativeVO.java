package com.snkit.springbootdemo.custorder;

public class CustomerNativeVO {

	public CustomerNativeVO(Long id, String name, String email, String addhar) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.addhar = addhar;
	}

	private Long id;

	private String name;

	private String email;

	private String addhar;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getAddhar() {
		return addhar;
	}

	public void setAddhar(String addhar) {
		this.addhar = addhar;
	}

}
