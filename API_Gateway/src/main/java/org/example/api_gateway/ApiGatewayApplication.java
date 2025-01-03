package org.example.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder)
	{
		return builder.routes()
				.route(r -> r
						.path("/api/sections/**")
						.uri("http://localhost:8080"))
				.route(r -> r
						.path("/api/elements/")
						.uri("http://localhost:8081"))
				.build();
	}

}
