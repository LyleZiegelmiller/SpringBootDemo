package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import (ApplicationConfiguration.class)
public class ConfigurationBasedAnnotationApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(ConfigurationBasedAnnotationApplication.class, args);
		
		SomeClass obj = applicationContext.getBean ( SomeClass.class );
		obj.setBeanProperty ();
		obj.printProperty ();
	}
}
