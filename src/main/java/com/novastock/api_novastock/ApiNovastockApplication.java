package com.novastock.api_novastock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiNovastockApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiNovastockApplication.class, args);
	}

}

/*
INSERT INTO producto (nombre, stock, precio, categoria) VALUES ('Teclado mecánico', 15, 79.99, 'Periféricos');
INSERT INTO producto (nombre, stock, precio, categoria) VALUES ('Ratón gaming', 25, 49.90, 'Periféricos');
*/