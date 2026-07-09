package com.rays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Main Spring Boot application class.
 * Entry point of the ORS10 backend system.
 *
 * Configures global CORS settings for Angular frontend integration.
 *
 * @author Saket
 */
@SpringBootApplication
public class ORS10Application {

	/**
	 * Application startup entry point.
	 */
	public static void main(String[] args) {
		SpringApplication.run(ORS10Application.class, args);
	}

	/**
	 * Configures Cross-Origin Resource Sharing (CORS)
	 * to allow Angular frontend (localhost:4200) to access APIs.
	 *
	 * @return WebMvcConfigurer CORS configuration bean
	 */
	@Bean
	public WebMvcConfigurer corsConfig() {
		WebMvcConfigurer w = new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:4200")
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
						.allowedHeaders("*")
						.allowCredentials(true);
			}
		};
		return w;
	}
}