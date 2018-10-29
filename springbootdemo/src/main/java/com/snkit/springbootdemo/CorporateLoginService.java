package com.snkit.springbootdemo;

import org.springframework.stereotype.Service;

@Service(value="cLoginService")
public class CorporateLoginService implements DemoLogin {

	@Override
	public String login(String number) {
		// TODO Auto-generated method stub
		return " CorporateLoginService  successful"+number;
	}

}
