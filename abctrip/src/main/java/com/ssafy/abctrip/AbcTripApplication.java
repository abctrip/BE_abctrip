package com.ssafy.abctrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class AbcTripApplication {

	public static void main(String[] args) {
		
		System.out.println("메인이야");
		SpringApplication.run(AbcTripApplication.class, args);
	}

}
