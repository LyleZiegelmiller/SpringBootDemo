package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@Import (AnnotationBasedApplicationConfiguration.class)
public class AnnotationBasedConfiguration_aka_ComponentScanning_Application {

	public static void main(String[] args) {
		SpringApplication.run(AnnotationBasedConfiguration_aka_ComponentScanning_Application.class, args);
	}
}
