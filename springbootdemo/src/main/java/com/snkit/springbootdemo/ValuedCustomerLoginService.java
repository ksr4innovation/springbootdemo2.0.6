package com.snkit.springbootdemo;

import org.springframework.stereotype.Service;

@Service(value="vCustomerLoginService")
public class ValuedCustomerLoginService implements DemoLogin {

	@Override
	public String login(String number) {
		// TODO Auto-generated method stub
		return "  ValuedCustomerLoginService  successful "+number;
	}

}
