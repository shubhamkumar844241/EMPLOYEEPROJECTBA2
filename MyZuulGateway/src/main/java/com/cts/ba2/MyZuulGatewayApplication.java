package com.cts.ba2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;


@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class MyZuulGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyZuulGatewayApplication.class, args);
	}
	
	
	
	@Bean 
	public Sampler sleuth() {
		return Sampler.ALWAYS_SAMPLE; //dont remove--for sleuth
	}

}
//1
