package com.snkit.springbootdemo;

import org.snkit.demo.test.HelloTestService;
import org.snkit.springboot.democomponentbean.CorporateAccountLogin;
import org.snkit.springboot.democomponentbean.ValidateAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfiguraiton {
	
	@Bean
	AccountLogin  retailCustomerService() {	
		
		System.out.println("   DemoConfiguraiton ===============  retailCustomerService");
		
		return new RetailCustomerService(addharValidate());
	}
	
	@Bean
	public DemoValidate addharValidate() {
		
		System.out.println("   DemoConfiguraiton ===============  addharValidate");
		
		return new AddharValidate();
	}
	
	
	@Bean
	public ValidateAccount validateAccount() {
		System.out.println("   DemoConfiguraiton ===============  ValidateAccount");
		return new CorporateAccountLogin();
	}
	
	@Bean
	HelloTestService helloTestService() {
		System.out.println("   DemoConfiguraiton ===============  HelloTestService");
		return new HelloTestService();
	}

}
