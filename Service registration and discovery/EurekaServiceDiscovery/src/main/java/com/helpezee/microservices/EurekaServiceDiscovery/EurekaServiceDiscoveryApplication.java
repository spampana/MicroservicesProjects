package com.helpezee.microservices.EurekaServiceDiscovery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.helpezee.microservices.EurekaServiceDiscovery.model.Employee;

@SpringBootApplication
@EnableEurekaClient
@RequestMapping("/")
@RibbonClient(name = "eurekaresgistryanddiscovery", configuration = AppConfiguration.class)
public class EurekaServiceDiscoveryApplication {

	@Autowired
	public RestTemplate template;

	@Bean
	@LoadBalanced
	public RestTemplate template() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaServiceDiscoveryApplication.class, args);
	}

	@GetMapping
	public List<Employee> getAllEmployees() {
		return (List<Employee>) template.getForEntity("http://eurekaresgistryanddiscovery/employees", Employee.class).getBody();

	}

}
