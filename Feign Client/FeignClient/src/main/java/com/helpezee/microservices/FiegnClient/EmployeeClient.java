package com.helpezee.microservices.FiegnClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="dummy" , url="http://localhost:8082")
public interface EmployeeClient {
	
	@GetMapping(value="/employees")
	public List<Employee> getAllEmployees();

}
