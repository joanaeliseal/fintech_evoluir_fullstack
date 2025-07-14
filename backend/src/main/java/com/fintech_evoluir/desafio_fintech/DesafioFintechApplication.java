package com.fintech_evoluir.desafio_fintech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Ativa as config do spring, injeção de dependência, suporte a JPA e inicia o servidor (tomcat)
public class DesafioFintechApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioFintechApplication.class, args);
	}

}
