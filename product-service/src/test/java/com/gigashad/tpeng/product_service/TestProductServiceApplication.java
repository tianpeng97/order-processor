package com.gigashad.tpeng.product_service;

import org.springframework.boot.SpringApplication;

public class TestProductServiceApplication {

	static void main(String[] args) {
		SpringApplication.from(ProductServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
