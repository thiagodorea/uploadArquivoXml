package com.tdorea.uploadarquivos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

//@EntityScan(basePackages = "com.tdorea.uploadarquivos.entities")
@SpringBootApplication
public class UploadArquivosApplication {

	public static void main(String[] args) {
		SpringApplication.run(UploadArquivosApplication.class, args);
	}

}
