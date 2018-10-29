package com.snkit.springbootdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(value=1)
public class HelloworldService implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("    From Command line runner  ::::::::::::::::::::::::  HelloworldService   ");
		
	}
	
	
	
	
}
