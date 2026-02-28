package com.ubam.videojuegos_api;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@SpringBootApplication
public class VideojuegosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideojuegosApiApplication.class, args);
	}

}
