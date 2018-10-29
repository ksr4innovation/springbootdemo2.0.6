package com.snkit.springbootdemoserviceclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class CustAddService {
	 private static final Logger logger = LoggerFactory.getLogger(CustAddService.class);
	


	@Autowired
	RestTemplate restTemplate;
	
	
	private String directCAllNonEureka(String input) {
		
		System.out.println(" directCAllNonEureka    Entering ");
		
		
		
		return "Response return from curcuit break fallback";
	}
	
	@HystrixCommand(commandKey="getCustBySpecificationNonEureka",
			fallbackMethod="directCAllNonEureka",
		commandProperties= {
		@HystrixProperty(name="circuitBreaker.requestVolumeThreshold" ,value="3"),
	    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000"),

		})
	public String getCustBySpecificationProxy(String input) {
		
		System.out.println(" getCustBySpecificationProxy    Entering ");
		
		MultiValueMap<String, String> headers= new LinkedMultiValueMap<String, String>();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");
		HttpEntity requestEntity  = new HttpEntity(input,headers);
		ResponseEntity<String> resp = restTemplate.exchange("http://localhost:9999/getCustBySpecification",
				HttpMethod.POST, requestEntity, String.class);
		System.out.println(" getCustBySpecificationProxy    Exit ");
		return resp.getBody();
	}
	@HystrixCommand(commandKey="getCustBySpecificationRibbon",
			fallbackMethod="getCustBySpecificationRibbonEureka",
		commandProperties= {
		@HystrixProperty(name="circuitBreaker.requestVolumeThreshold" ,value="3"),
	    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000"),

		})
	public String getCustBySpecificationRibbon(String input) {
		System.out.println("Main:  getCustBySpecificationRibbon    Entering ");
		MultiValueMap<String, String> headers= new LinkedMultiValueMap<String, String>();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");
		HttpEntity requestEntity  = new HttpEntity(input,headers);		
		
		ResponseEntity<String> resp = restTemplate.exchange("http://CUSTADDSERVICE-DEMO/getCustBySpecification",
				HttpMethod.POST, requestEntity, String.class);
		System.out.println("Main: getCustBySpecificationRibbon    Exit ");
		return resp.getBody();
		
	
	}
	private String getCustBySpecificationRibbonEureka(String input) {
		
		logger.info(" Fallback : getCustBySpecificationRibbonEureka    Entering ");
		
		
		
		return "getCustBySpecificationRibbonEureka Response return from curcuit break fallback";
	}
	
	
	
	@HystrixCommand(commandKey="getCustNaviteQuery",
			fallbackMethod="getCustNaviteQueryRibbonEureka",
		commandProperties= {
		@HystrixProperty(name="circuitBreaker.requestVolumeThreshold" ,value="3"),
	    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000"),

		})
		public String getCustNaviteQuery(String input) {
		logger.info("Main:  getCustNaviteQueryRibbonEureka    Entering ");
		MultiValueMap<String, String> headers= new LinkedMultiValueMap<String, String>();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");
		HttpEntity requestEntity  = new HttpEntity(input,headers);		
		
		ResponseEntity<String> resp = restTemplate.exchange("http://CUSTADDSERVICE-DEMO/getCustNaviteQuery",
				HttpMethod.POST, requestEntity, String.class);
		logger.info("Main: getCustNaviteQueryRibbonEureka    Exit ");
		return resp.getBody();
		
	
	}
	
	private String getCustNaviteQueryRibbonEureka(String input) {
		
		logger.info(" Fallback : getCustNaviteQueryRibbonEureka    Entering ");
		
		
		
		return "getCustBySpecificationRibbonEureka Response return from curcuit break fallback";
	}
}
