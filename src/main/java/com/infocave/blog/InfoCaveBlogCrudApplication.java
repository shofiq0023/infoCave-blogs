package com.infocave.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class InfoCaveBlogCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfoCaveBlogCrudApplication.class, args);
	}

}
