package com.snkit.springbootdemo.custorder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

@Entity
@Table(schema = "microservice", name = "customer")

@SqlResultSetMappings({
	@SqlResultSetMapping(name = "customerMapping", classes = {
			@ConstructorResult(targetClass = CustomerNativeVO.class, columns = {
					@ColumnResult(name = "id", type = Long.class), @ColumnResult(name = "name", type = String.class),
					@ColumnResult(name = "email", type = String.class),
					@ColumnResult(name = "addhar", type = String.class) }) }),
	@SqlResultSetMapping(name = "abc", classes = {
			@ConstructorResult(targetClass = CustomerNativeVO.class, columns = {
					@ColumnResult(name = "id", type = Long.class), @ColumnResult(name = "name", type = String.class),
					@ColumnResult(name = "email", type = String.class),
					@ColumnResult(name = "addhar", type = String.class) }) })
})
@NamedNativeQueries({
		@NamedNativeQuery(name = "native.customerquery", query = "select cust.* from microservice.customer cust where cust.name=?1", resultSetMapping = "customerMapping")	
})
public class CustomerEntity implements Serializable {

	public CustomerEntity() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "addhar")
	private String addhar;

	@OneToMany(mappedBy = "customerEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<OrderEntity> orderEntityList = new ArrayList<OrderEntity>();

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

	public List<OrderEntity> getOrderEntityList() {
		return orderEntityList;
	}

	public void setOrderEntityList(List<OrderEntity> orderEntityList) {
		this.orderEntityList = orderEntityList;
	}

}
