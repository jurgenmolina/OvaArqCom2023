package com.ova.arq2023;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class OvaArquitecturaComputadoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(OvaArquitecturaComputadoresApplication.class, args);
	}

}
