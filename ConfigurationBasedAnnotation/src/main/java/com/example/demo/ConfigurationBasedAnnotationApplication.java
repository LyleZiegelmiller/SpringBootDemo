package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigurationBasedAnnotationApplication {

    TestBean testBean;
    
	public static void main(String[] args) {
		SpringApplication.run(ConfigurationBasedAnnotationApplication.class, args);
		
		ConfigurationBasedAnnotationApplication obj = new ConfigurationBasedAnnotationApplication();
		obj.printProperty();
	}
	
	void printProperty() {
	    System.out.println("testBean.getProperty () = " +  testBean.getProperty ());
	}
	
	void setProperty ( @Autowired TestBean testBean) {
        this.testBean = testBean;
	}
}
