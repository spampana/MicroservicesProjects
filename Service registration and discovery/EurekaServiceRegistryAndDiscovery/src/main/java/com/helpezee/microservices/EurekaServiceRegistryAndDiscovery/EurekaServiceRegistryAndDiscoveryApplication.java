package com.helpezee.microservices.EurekaServiceRegistryAndDiscovery;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;

import com.helpezee.microservices.EurekaServiceRegistryAndDiscovery.model.Employee;
import com.helpezee.microservices.EurekaServiceRegistryAndDiscovery.repo.EmpRepository;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableJpaRepositories(basePackages = "com.helpezee.microservices.EurekaServiceRegistryAndDiscovery.repo")
@EntityScan(basePackages = "com.helpezee.microservices.EurekaServiceRegistryAndDiscovery.model")
public class EurekaServiceRegistryAndDiscoveryApplication {

	@Autowired
	EmpRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(EurekaServiceRegistryAndDiscoveryApplication.class, args);
	}

	@Bean("saveData")
	public void insert() {
		String[] names = new String[] { "Simran", "Saloni", "Alone", "Ashwini", "Amar" };
		String[] projects = new String[] { "Project1", "Project2", "Project3" };

		for (int i = 1; i < 50; i += 1) {
			Employee e = new Employee();
			e.setName(names[i % names.length]);
			e.setProject(projects[i % projects.length]);
			e.setSalary((int) (Math.random() * 100) * 10);
			e.setBdate(new Date());
			e.setCom(i * 10);
			repo.save(e);
		}

	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

}
