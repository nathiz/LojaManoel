package com.loja.empacotamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
    info = @Info(
        title = "Minha API",
        version = "1.0",
        description = "Documentação da API com Swagger"
    )
)
@SpringBootApplication
public class EmpacotamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpacotamentoApplication.class, args);
	}

}