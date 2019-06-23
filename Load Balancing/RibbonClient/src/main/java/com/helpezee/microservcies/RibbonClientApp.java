package com.helpezee.microservcies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RequestMapping(value="/")
@RibbonClient(name="myapp111", configuration=AppConfiguration.class)
public class RibbonClientApp {

	public static void main(String[] args) {
		SpringApplication.run(RibbonClientApp.class, args);
	}
	@Autowired
	private RestTemplate template;
	
	@Bean
	@LoadBalanced
	public RestTemplate rest(){
		return new RestTemplate();
	}
	@GetMapping
	public String data()
	{
	//	String s = template.getForEntity("http://localhost:8090/myapp",String.class).getBody();
		String s = template.getForEntity("http://myapp111/myapp",String.class).getBody();
		System.out.println(s);
		return "<h2>In RibbonClient App</h2> " + s;
	}
	
}
