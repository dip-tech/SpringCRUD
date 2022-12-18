package com.spring.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigure() {
		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// TODO Auto-generated method stub
				WebMvcConfigurer.super.addCorsMappings(registry);
				registry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods("*").maxAge(3600L)
						.exposedHeaders("Authorization").allowCredentials(true);
			}

		};
	}

}
