package com.example.productCatalog;


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
public class ProductCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCatalogApplication.class, args);

	}
	
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example"))
				.build()
				.apiInfo(apiDetails());
		
	}
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Product Catalog API",
				"sample Api for itWorx interview task",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("moamen Hossam","", "moamen.hossam@outlook.com"),
				"API License",
				" ",
				Collections.emptyList());
				
	}
}
