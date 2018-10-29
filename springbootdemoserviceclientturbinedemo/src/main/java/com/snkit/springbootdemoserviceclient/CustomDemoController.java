package com.snkit.springbootdemoserviceclient;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CustomDemoController {
	 private static final Logger logger = LoggerFactory.getLogger(CustomDemoController.class);
		
	@Autowired
	CustAddServiceTestDemo2222 custAddService;
	
	@PostMapping(value="getCustBySpecificationProxy",consumes="application/json")
	public String getCustBySpecification(@RequestBody String req) {
		return custAddService.getCustBySpecificationProxy(req);
	}
	
	@PostMapping(value="getCustBySpecificationRibbon",consumes="application/json")
	public String getCustBySpecificationRibbon(@RequestBody String req) {
		return custAddService.getCustBySpecificationRibbon(req);
	}
	
	@PostMapping(value="getCustNaviteQuery",consumes="application/json")
	public String getCustNaviteQuery(@RequestBody String req) {
		
		logger.info("Entring in CustAddServiceTestDemo2222 getCustNaviteQuery ");
		return custAddService.getCustNaviteQuery(req);
	}
	
	
	
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	@GetMapping(value="/getInstances")	
	public void getServiceInstance() {
		System.out.println("   getServiceInstance name ");
		
		List<ServiceInstance> serviceInstance =discoveryClient.getInstances("CUSTADDSERVICE-DEMO");
		
		
		serviceInstance.forEach(instance -> {
			System.out.println("   Host name "+instance.getHost()+" port "+instance.getPort());
		});
		
	}
}
