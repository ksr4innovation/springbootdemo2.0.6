package com.snkit.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.snkit.springbootdemo.custorder.CustomerEntity;
import com.snkit.springbootdemo.custorder.CustomerRepository;
import com.snkit.springbootdemo.custorder.OrderEntity;

@SpringBootApplication
@EnableJpaRepositories("com.snkit")
@EnableDiscoveryClient
public class SpringbootdemoApplication implements CommandLineRunner{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	SequenceGeneratorRepository sequenceGeneratorRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		SequenceGeneratorEntity custId = 	sequenceGeneratorRepository.findByType("Customer");
		
		Long cid = custId.getValue();
		
		custId.setValue(custId.getValue()+1);
		
		sequenceGeneratorRepository.saveAndFlush(custId);
		
		SequenceGeneratorEntity orderId = 	sequenceGeneratorRepository.findByType("Order");
		
		Long oId = orderId.getValue();
	
	System.out.println("  From command line   "+custId+"   ===="+orderId);
	
	CustomerEntity cust = new CustomerEntity();
	
	cust.setAddhar("9999999999");
	cust.setEmail("test@microservice.com");
	cust.setName("demo microserivce");
	cust.setId(cid);
	
	OrderEntity order = new OrderEntity();
	
	order.setAmt(100L);	
	order.setQuantity(4L);
	order.setId(oId);	
	order.setCustomerEntity(cust);
	
	
	OrderEntity order2 = new OrderEntity();
	oId = oId+1;
	order2.setAmt(100L);
	order2.setCustomerEntity(cust);
	order2.setQuantity(4L);
	order2.setId(oId);
	
	orderId.setValue(oId+1);
	cust.getOrderEntityList().add(order);
	
	cust.getOrderEntityList().add(order2);
	
	
	customerRepository.save(cust);
	
	sequenceGeneratorRepository.saveAndFlush(orderId);
	sequenceGeneratorRepository.saveAndFlush(custId);
	}
	
	
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
}
