package com.example.demo.config;

import javax.servlet.ServletContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	@Bean
	public Docket SwaggerApi(ServletContext servletContext) {
		
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
	        .paths(PathSelectors.any())
	        .build()
	        .apiInfo(apiInfo());
	}
	
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
			.title("도서관리API")
			.description("Swagger Ui")
	        .license("License")
	        .licenseUrl("http://localhost:9090")
	        .version("1.0")
	        .build();
	}
	
	
	
	
	
	
}
