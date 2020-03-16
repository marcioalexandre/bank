package com.capgemini.desafio;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BancoApplication 
{
	private static final Logger LOGGER = Logger.getLogger(BancoApplication.class.getName());

	public static void main(String[] args) 
	{
		LOGGER.info(LOGGER.getName());
		SpringApplication.run(BancoApplication.class, args);
	}

}
