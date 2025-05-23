package com.seuManoel.seuManoel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "API de Embalagem de Pedidos", version = "1.0", description = "Organiza produtos em caixas"))
@SpringBootApplication
public class SeuManoelApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeuManoelApplication.class, args);
	}

}
