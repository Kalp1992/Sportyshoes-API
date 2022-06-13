package com.sportyshoes;


import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SportyshoesApp {

	public static void main(String[] args) {
		SpringApplication.run(SportyshoesApp.class, args);
		System.out.println("Sportyshoes App works!");
	}
	
	/*@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Inspecting all the beans in the container:");

			String[] beanNames = ((ListableBeanFactory) ctx).getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
		};
	}*/
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.sportyshoes"))
				.build()
				.apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Sportyshoes API",
				"Spring Boot REST API for sportyshoes.com",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Kalpana Rathod", "https://github.com/Kalp1992/", "kalpanarathod6@gmail.com"),
				"API License",
				"https://github.com/Kalp1992/",
				Collections.emptyList()
				);

}}
