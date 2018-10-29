package com.snkit.springbootdemo;

import org.springframework.stereotype.Service;

@Service(value="rLoginService")
public class RetailLoginService implements DemoLogin {

	@Override
	public String login(String number) {
		
		return "RetailLoginService  successful   === "+number;
	}

}
