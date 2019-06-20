package com.helpezee.microservices.FiegnClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//https://reqres.in/api/users?page=1
@FeignClient(name = "demo2", url = "https://reqres.in/api")
public interface UserClient {

	@GetMapping(value = "/users?page=1")
	public Wrapper getData();

}
