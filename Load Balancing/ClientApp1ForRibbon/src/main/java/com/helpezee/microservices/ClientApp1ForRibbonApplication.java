package com.helpezee.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class ClientApp1ForRibbonApplication {

	@GetMapping(value = "/myapp")
	public String getdata(){
		return "<h1  style='color:red' >MyData </h1>";
	}

	public static void main(String[] args) {
		SpringApplication.run(ClientApp1ForRibbonApplication.class, args);
	}

	
}
