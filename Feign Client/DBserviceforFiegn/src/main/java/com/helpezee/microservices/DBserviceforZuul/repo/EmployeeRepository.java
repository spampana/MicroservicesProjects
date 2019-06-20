package com.helpezee.microservices.DBserviceforZuul.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helpezee.microservices.DBserviceforZuul.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
