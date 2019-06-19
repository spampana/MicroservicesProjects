package com.helpezee.microservices.Hystrix;

import java.io.IOException;
import java.net.URL;

public class CreateError {

	public static void main(String[] args) throws IOException {

		for(int i=0;i<500;i++){
			URL  url1= new URL("http://localhost:8080");
			url1.getContent();
			URL  url2= new URL("http://localhost:8080/abc");
			url2.getContent();
			
		}

	}

}
