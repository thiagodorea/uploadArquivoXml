package com.tdorea.agentes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

//@EntityScan(basePackages = "com.tdorea.agentes.entities")
@SpringBootApplication
public class AgentesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgentesApplication.class, args);
	}

}
