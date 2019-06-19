package com.helpezee.microservices.DBserviceforZuul;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helpezee.microservices.DBserviceforZuul.model.Employee;
import com.helpezee.microservices.DBserviceforZuul.repo.EmployeeRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.helpezee.microservices.DBserviceforZuul.repo")
@EntityScan(basePackages = "com.helpezee.microservices.DBserviceforZuul.model")
@RestController
@RequestMapping("/")
public class DBserviceforFeignApplication {

	@Autowired
	EmployeeRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(DBserviceforFeignApplication.class, args);
	}

	@Bean
	public void saveData() {
		String[] names = { "Satya", "Narayana", "Dhana", "Nisha", "Tata", "Ambani" };
		for (int i = 0; i < 10; i++) {
			Employee emp = new Employee();
			emp.setBdate(new Date());
			emp.setCom(10 * i);
			emp.setProject("SVT" + i);
			emp.setName(names[i % names.length]);
			emp.setSalary(100000 * Math.random());
			repo.save(emp);
		}
	}

	@GetMapping("/")
	public String index() {
		return "<a href='employees'> Get Employees</a>";
	}

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return repo.findAll();
	}
	
	@GetMapping("/getAllemployees")
	public List<Employee> getAllEmployees() {
		if(new Date().getTime() % 2 == 0){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			throw new RuntimeException("Error");
		}
		return repo.findAll();
	}

}
