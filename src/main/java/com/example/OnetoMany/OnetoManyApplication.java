package com.example.OnetoMany;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnetoManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnetoManyApplication.class, args);
	}

	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
