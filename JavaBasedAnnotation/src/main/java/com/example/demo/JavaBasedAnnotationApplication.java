package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import (JavaBasedAnnotationApplicationConfiguration.class) // It's proper to have @Import here. See /32-jdbc-autoconfig-solution/src/main/java/rewards/RewardsApplication.java for reference.
public class JavaBasedAnnotationApplication {

	public static void main(String[] args) {
	    
		//ApplicationContext context = SpringApplication.run(JavaBasedAnnotationApplicationConfiguration.class, args);
		ApplicationContext context = SpringApplication.run(JavaBasedAnnotationApplication.class, args);
		
		Integer i = context.getBean ( "someInteger", Integer.class );
		
		System.out.println("i = " + i);
	}

}
