package com.example.perfume_ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@OpenAPIDefinition
@SpringBootApplication
public class PerfumeEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PerfumeEcommerceApplication.class, args);
	}

}
