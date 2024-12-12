package com.ssafy.abctrip.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
//import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.annotations.info.Info;

//Swagger-UI 확인
//http://localhost/vue/swagger-ui/index.html

@OpenAPIDefinition(
	    info = @Info(
	        title = "ABC TRIP API 명세서",
	        description = "<h3>ABC TRIP API Reference for Developers</h3>Swagger를 이용한 VUE API<br><img src=\"/vue/img/abc-logo.png\" width=\"150\">",
	        version = "v1",
	        contact = @Contact(
	            name = "hissam",
	            email = "hissam@ssafy.com",
	            url = "http://edu.ssafy.com"
	        )
	    )
	)
@Configuration
public class SwaggerConfiguration {
	
//	@Bean
//	public OpenAPI openAPI() {
//		Info info = new Info().title("SSAFY VUE API 명세서").description(
//				"<h3>SSAFY API Reference for Developers</h3>Swagger를 이용한 VUE API<br><img src=\"/assets/img/ssafy_logo.png\" width=\"150\">")
//				.version("v1").contact(new io.swagger.v3.oas.models.info.Contact().name("hissam")
//						.email("hissam@ssafy.com").url("http://edu.ssafy.com"));
//
//		return new OpenAPI().components(new Components()).info(info);
//	}
		
	@Bean
	public GroupedOpenApi allApi() {
		return GroupedOpenApi.builder().group("ssafy-all").pathsToMatch("/**").build();
	}

	@Bean
	public GroupedOpenApi boardApi() {
		return GroupedOpenApi.builder().group("ssafy-board").pathsToMatch("/board/**").build();
	}
	
	@Bean
	public GroupedOpenApi userApi() {
		return GroupedOpenApi.builder().group("ssafy-user").pathsToMatch("/user/**").build();
	}
	
	@Bean
	public GroupedOpenApi mapApi() {
		return GroupedOpenApi.builder().group("ssafy-map").pathsToMatch("/map/**").build();
	}
}
