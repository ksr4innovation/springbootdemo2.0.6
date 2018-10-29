package com.snkit.springbootdemo;

public class RetailCustomerService implements AccountLogin {
	
	DemoValidate validate;
	
	

	
	RetailCustomerService(DemoValidate validate ) {
		this.validate = validate; 
		
	}
	
	EmployeeVO emp = new EmployeeVO();
	
	@Override
	public String Login(String accountNumber) {
		
		
		
		
		
		ValdiateVO v= new ValdiateVO();
		validate.valiate(v);
		
		
		
		
		return "RetailCustomerService";
	}

}
