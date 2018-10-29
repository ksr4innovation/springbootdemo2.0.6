package com.snkit.springbootdemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.snkit.springboot.democomponentbean.ValidateAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class DemoController {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	DemoService demoService;
	
	@Autowired
	AccountLogin  accountLogin;
	
	@Autowired
	ValidateAccount validateAccount;
	
	@Autowired
	@Qualifier("cLoginService")
	DemoLogin demoLogin;
	
	
	private Map<EmployeeVO,EmployeeVO> map = new HashMap<EmployeeVO,EmployeeVO>();

	@GetMapping(value = "/sayHi")
	public String sayHi() {
		
		return demoLogin.login("12345");
	}

	@RequestMapping(value = "/sayRequest", method = RequestMethod.GET)
	public String sayHiReq() {
		accountLogin.Login("1234");
		return "Hello world"+validateAccount.Login("12345");
	}

	@GetMapping(value = "/getEmp", consumes = { "application/json", "application/xml" },
			produces = {"application/json", "application/xml" })
	public List<EmployeeVO> getEmp() {
		accountLogin.Login("1234");
		List<EmployeeVO> list = new ArrayList<EmployeeVO>();

		EmployeeVO e = new EmployeeVO("test");

		e.setName("test");
		e.setCountry("India");
		e.setEmail("test@test.com");
		e.setState("telangana");
		
		e.setCmp("A");

		list.add(e);

		return list;

	}
	
	@GetMapping(value = "/getEmp", consumes = { "application/vnd.snkit-v1+json", 
			"application/vnd.snkit-v1+xml" }, 
			produces = {"application/vnd.snkit-v1+json",
					"application/vnd.snkit-v1+xml" })
	public List<EmployeeVO> getEmpCompB() {
		accountLogin.Login("1234");
		List<EmployeeVO> list = new ArrayList<EmployeeVO>();

		EmployeeVO e = new EmployeeVO("test");

		e.setName("test");
		e.setCountry("India");
		e.setEmail("test@test.com");
		e.setState("telangana");
		e.setCmp("B");
		list.add(e);

		return list;

	}
	
	@GetMapping(value = "/getEmp", consumes = { "application/vnd.snkit-v2+json",
			"application/vnd.snkit-v2+xml" }, 
			produces = {
			"application/vnd.snkit-v2+json", 
			"application/vnd.snkit-v2+xml" })
	public List<EmployeeVO> getEmpCompC() {

		List<EmployeeVO> list = new ArrayList<EmployeeVO>();

		EmployeeVO e = new EmployeeVO("test");

		e.setName("test");
		e.setCountry("India");
		e.setEmail("test@test.com");
		e.setState("telangana");
		e.setCmp("C");
		list.add(e);

		return list;

	}
	
	
	@PostMapping(value="/saveEmp",consumes = { "application/json",
			"application/xml" }, produces = {
					"application/json", "application/xml" })
	public Collection<EmployeeVO> saveData(@Valid @RequestBody EmployeeVO empVO){
		System.out.println("    From Command line runner  ::::::::::::::::::::::::   ");
		

		map.put(empVO, empVO);
		
		return map.values();
	}
	@PostMapping(value="/saveEmp",consumes = { "application/vnd.snkit-v1+json",
			"application/xml" }, produces = {
			"application/vnd.snkit-v1+json", "application/xml" })
	public EmployeeVO saveData(@RequestBody String empVO){		
		EmployeeVO employeeVO = objectMapper.convertValue(empVO, EmployeeVO.class);
		employeeVO.setCmp("Using Object Mapper conversion");
		demoService.findUser();
		
		return employeeVO;
		
	}
	
	@PostMapping(value="/saveEmpWithRequestBody",consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public Collection<EmployeeVO> saveDataWithOutRequestBody( EmployeeVO empVO){
		
		demoService.payment();
		
		
		map.put(empVO, empVO);
		
		return map.values();
	}
	

}
