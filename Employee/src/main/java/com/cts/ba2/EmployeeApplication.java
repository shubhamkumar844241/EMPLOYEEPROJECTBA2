package com.cts.ba2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@EnableHystrix
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	
	@Bean
	public Sampler sleuthrequest() {
		return Sampler.ALWAYS_SAMPLE; //DONOT REMOVE -FOR SLEUTH TO HANDLE ALL LOGGER.INFO-->log
				
	}
	
	
//@Bean 
//public Docket swaggerConfiguration() {
//		
//		return new Docket(DocumentationType.SWAGGER_2) .select()
//				.paths(PathSelectors.ant("/"))
//				.apis(RequestHandlerSelectors.basePackage("com.cts.ba2")).build();
//		
//	}
//	
//	
	
	
}
//1
