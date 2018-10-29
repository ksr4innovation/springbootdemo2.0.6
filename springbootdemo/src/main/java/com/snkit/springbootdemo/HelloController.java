package com.snkit.springbootdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class HelloController {
	
	@GetMapping
	public String getEmpName() {
		return "xyz  getEmpName";
	}
	@PostMapping
	public String saveEmpName() {
		return "xyz @PostMapping";
	}

}
