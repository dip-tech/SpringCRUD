package com.spring.crud;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.RestAssured;

@SpringBootTest
class SpringCrudApplicationTests {

	@Test
	void contextLoads() {
		RestAssured.baseURI = "http://localhost:8001/";
		given().body("{\n" + "				    \"username\":\"dipankar8dutta@gmail.com\",\n"
				+ "				    \"password\":\"dip@dutta\"\n" + "				}").when().post("user/login").then()
				.assertThat().statusCode(200);
	}

}
