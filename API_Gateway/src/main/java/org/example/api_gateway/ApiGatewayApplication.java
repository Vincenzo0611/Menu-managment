package org.example.api_gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

	@Value("${API_CATEGORIES_URL}")
	private String categoriesUri;

	@Value("${API_ELEMENTS_URL}")
	private String elementsUri;

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r
						.path("/api/sections/**")
						.uri(categoriesUri))  // użycie zmiennej środowiskowej
				.route(r -> r
						.path("/api/elements/")
						.uri(elementsUri))  // użycie zmiennej środowiskowej
				.build();
	}
}
