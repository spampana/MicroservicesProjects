package com.helpezee.microservices.EurekaServiceRegistryAndDiscovery.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helpezee.microservices.EurekaServiceRegistryAndDiscovery.model.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer> {

}
