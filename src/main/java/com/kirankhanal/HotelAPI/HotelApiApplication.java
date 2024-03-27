package com.kirankhanal.HotelAPI;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(
				title="Hotel Management System CRUD API Documentation",
				version = "1.0.0",
				description = "Welcome to the documentation for the HMS Rest APIs. This set of APIs" +
						"allows developers to seamlessly integrate hotel management functionalities in their application. This " +
						"documentation provides comprehensive guide through the process of integration these APIs for smooth communication" +
						"between the system and the end users."
		),
		servers=@Server(
				url="http://localhost:8080",
				description="This server hosts the Hotel Management System APIs, providing endpoints for creating, updating, deleting, and retrieving hotel information."
		)

)
public class HotelApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelApiApplication.class, args);
	}

}
