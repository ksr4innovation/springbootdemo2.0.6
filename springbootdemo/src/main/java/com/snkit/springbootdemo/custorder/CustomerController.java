package com.snkit.springbootdemo.custorder;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	 private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
		


	
	CustOrderService inputService;
	
	public CustomerController(CustOrderService custOrderInterface) {
		this.inputService = custOrderInterface;
	}
	
	@PostMapping(value="saveOrder",consumes="application/json")
	public String saveOrder(@RequestBody CustomerOrderReq req) {		
		return inputService.saveOrder(req);
	}
	
	
	@PostMapping(value="getCustInfoByName",consumes="application/json")
	public CustomerOrderVO getCustInfoByName(@RequestBody CustomerOrderReq req) {		
		return inputService.findCustInfoByName(req);
	}
	
	@PostMapping(value="getCustInfoByNameAndEmail",consumes="application/json")
	public CustomerOrderVO getCustInfoByNameAndEmail(@RequestBody CustomerOrderReq req) {		
		return inputService.findCustInfoNameAndEmail(req);
	}
	
	@PostMapping(value="getCustInfoByCustInfo",consumes="application/json")
	public CustomerOrderVO getCustInfoByCustInfo(@RequestBody CustomerOrderReq req) {		
		return inputService.findCustInfoNameAndEmailAndAddhar(req);
	}
	
	
	@PostMapping(value="getCustToAvoidNPlus1",consumes="application/json")
	public CustomerOrderVO getCustToAvoidNPlus1(@RequestBody CustomerOrderReq req) {		
		return inputService.getCustToAvoidNPlus1(req);
	}
	
	@PostMapping(value="getCustNaviteQuery",consumes="application/json")
	public List<CustomerNativeVO> getCustNaviteQuery(@RequestBody CustomerOrderReq req) {		
	
		logger.info("Entering into actual microservie GetCustNative query");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inputService.getCustNaviteQuery(req);
	}
	
	@PostMapping(value="getCustBySpecification",consumes="application/json")
	public CustOrderResp getCustBySpecification(@RequestBody CustomerOrderReq req) {
		
		logger.info("Entering into actual microservie getCustBySpecification ");
		
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return inputService.getCustBySpecification(req);
	}
}
