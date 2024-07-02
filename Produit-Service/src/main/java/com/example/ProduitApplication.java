package com.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.IOException;


@EnableWebMvc
@SpringBootApplication
@EnableScheduling
@EntityScan(basePackages = {"com.example.Entities", "DTO.Entities.User", "DTO.Entities.stock", "DTO.Entities.produit"})
@ComponentScan(basePackages = {"com.example", "DTO.Entities.User", "DTO.Entities.stock", "DTO.Entities.produit"})
@EnableFeignClients(basePackages = "com.example.Client")

public class ProduitApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProduitApplication.class, args);

	}
	}




