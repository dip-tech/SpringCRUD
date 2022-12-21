package com.spring.crud;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringCrudApplicationTests {

	@Test
	void contextLoads() {

		System.out.print("TEST");
//		RestAssured.baseURI = "http://localhost:8001";
//		given().log().all().header("Content-Type", "application/json")
//				.body("{\n" + "				    \"username\":\"dipankar8dutta@gmail.com\",\n"
//						+ "				    \"password\":\"dip@dutta\"\n" + "				}")
//				.when().log().all().post("/user/login").then().assertThat().statusCode(200);

	}

}
