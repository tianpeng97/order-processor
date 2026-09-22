package com.gigashad.tpeng.product_service;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.mongodb.MongoDBContainer;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {

	@ServiceConnection
	static MongoDBContainer mongo = new MongoDBContainer("mongo:latest");

	@LocalServerPort
	private Integer port;

	@BeforeAll
	static void beforeAll() {
		mongo.start();
	}

	@AfterAll
	static void afterAll() {
		mongo.stop();
	}

	@BeforeEach
	void setup() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	@Test
	void POST_Product_WithValidProduct_Returns201AndProduct() {
		String requestBody = """
				{
				  "name": "iphone",
				  "description": "iphone 15",
				  "price": 1000
				}
				""";
		RestAssured.given()
				.contentType("application/json")
				.body(requestBody)
				.when()
				.post("/api/product")
				.then()
				.statusCode(201)
				.body("id", Matchers.notNullValue())
				.body("name", Matchers.equalTo("iphone"))
				.body("description", Matchers.equalTo("iphone 15"))
				.body("price", Matchers.equalTo(1000));
	}
}
