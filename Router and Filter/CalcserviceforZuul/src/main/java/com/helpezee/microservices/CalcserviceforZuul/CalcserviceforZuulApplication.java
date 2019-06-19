package com.helpezee.microservices.CalcserviceforZuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class CalcserviceforZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalcserviceforZuulApplication.class, args);
	}

	@GetMapping("/calc")
	public String hello(){
		return "<h1> Hello I am calc service <h1>";
	}
	
	@GetMapping("/")
	public String index() {
		return "<a href='calc'> Get Calc </a>";
	}
}
