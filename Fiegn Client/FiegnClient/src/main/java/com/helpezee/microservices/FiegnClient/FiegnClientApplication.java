package com.helpezee.microservices.FiegnClient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@SpringBootApplication
@RestController
@RequestMapping(value = "/")
@EnableFeignClients
public class FiegnClientApplication {

	@Autowired
	EmployeeClient empClient;

	@Autowired
	UserClient userCleint;
	
	@Bean
	public RequestInterceptor requestint(){
		return new RequestInterceptor() {
			
			@Override
			public void apply(RequestTemplate requestTemplate) {
				requestTemplate.header("user-agent","Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36");
				
			}
		};
		
	}

	public static void main(String[] args) {
		SpringApplication.run(FiegnClientApplication.class, args);
	}

	@GetMapping
	public List<Employee> list() {
		return empClient.getAllEmployees();
	}

	@GetMapping("/userDetails")
	public String getWrapper() {
		Wrapper wrapper = userCleint.getData();
		String str = "<h1> Page=" + wrapper.getPage() + "</h>";
		str += "<table border='2'>";
		List<User> userdata = wrapper.getData();
		for (User user : userdata) {
			str += "<tr><td>" + user.getId() + "</td><td>" + user.getEmail() + "</td><td>" + user.getFirst_name()
				+ "</td><td>" + user.getLast_name() + "</td><td><img src='" + user.getAvatar() +"'/></td></tr>";
		}
		str += "</table>";
		return str;
	}

}
