package com.my.grocery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GroceryApplication {

	public static void main(String[] args) {

		SpringApplication.run(GroceryApplication.class, args);
		System.out.println("Rest API Grocery Application Service Started...");

	}

}
