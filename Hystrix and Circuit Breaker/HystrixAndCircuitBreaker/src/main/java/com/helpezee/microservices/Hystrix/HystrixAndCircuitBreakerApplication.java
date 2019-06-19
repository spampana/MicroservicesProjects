package com.helpezee.microservices.Hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SpringBootApplication
@RestController
@EnableCircuitBreaker // shows circuits
@EnableHystrix // enables http://localhost:8080/actuator/hystrix.stream
@EnableHystrixDashboard // enables http://localhost:8080/hystrix
public class HystrixAndCircuitBreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixAndCircuitBreakerApplication.class, args);
	}

	@GetMapping("/")
	@HystrixCommand(commandKey = "demo", groupKey = "db", fallbackMethod = "method1")
	public Object[] get() {
		System.out.println("Actual Method");
		RestTemplate template = new RestTemplate();
		ResponseEntity<Object[]> x = template.getForEntity("http://localhost:8082/getAllemployees", Object[].class);
		return x.getBody();
	}
	
	@GetMapping("/abc")
	@HystrixCommand(commandKey = "demo1", groupKey = "db1", fallbackMethod = "method1")
	public Object[] get1() {
		System.out.println("Actual Method");
		RestTemplate template = new RestTemplate();
		ResponseEntity<Object[]> x = template.getForEntity("http://localhost:8082/getAllemployees", Object[].class);
		return x.getBody();
	}

	public Object[] method1() {
		System.out.println("----------fallback method");
		String[] data = { "static Data", "simple data" };
		return data;
	}

}
