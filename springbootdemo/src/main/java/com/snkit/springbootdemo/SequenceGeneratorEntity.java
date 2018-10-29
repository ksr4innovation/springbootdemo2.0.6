package com.snkit.springbootdemo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="microservice",name="sequence_generator")
public class SequenceGeneratorEntity implements Serializable {

	
	public SequenceGeneratorEntity() {
		
	}
	
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="type")
	private String type;
	
	@Column(name="value")
	private Long value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "SequenceGeneratorEntity [id=" + id + ", type=" + type + ", value=" + value + "]";
	}
	
}
