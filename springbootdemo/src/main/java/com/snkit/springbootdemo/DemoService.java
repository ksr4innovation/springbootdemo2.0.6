package com.snkit.springbootdemo;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(value=2)
public class DemoService  implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("    From Command line runner  ::::::::::::::::::::::::  DemoService   ");
		
		String str = Arrays.stream(args).collect(Collectors.joining("||"));
		
		System.out.println("    From Command line runner  ::::::::::::::::::::::::  ====   "+str);
		
	}
	
	public void findUser()  {
		throw new PaymentModuleException("CUST001"," User not found");
		
	}
	
	public void payment()  {
		throw new ThirdPartyException("PATMENT001"," ThirdPartyException paymentfailed ");
		
	}

	
}
