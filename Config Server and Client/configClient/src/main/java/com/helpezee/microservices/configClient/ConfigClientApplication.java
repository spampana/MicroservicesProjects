package com.helpezee.microservices.configClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope // to support reloading of properties without restarting server
public class ConfigClientApplication {
	
	@Value("${message:MyHelloMessage}")
	private String msg;

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}
	
	@GetMapping("/display")
	public String getProperties() {
		return msg;
		
	}

}
