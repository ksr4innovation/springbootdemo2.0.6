package com.snkit.springbootdemo;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service
public class AppliactionRunnerExampleService implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
	
		
			String str = Arrays.stream(args.getSourceArgs()).collect(Collectors.joining("||"));
		
		System.out.println("    From AppliactionRunnerExampleServicer  ::::::::::::::::::::::::  ====   "+str);
		
		System.out.println("   from AppliactionRunnerExampleService Runner =============  ");
		
	}

}
