package com.example.demo;


//import java.util.logging.Level;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.slf4j.event.Level;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

import com.example.demo.rest.AcmeInfo;

@Import (JavaBasedAnnotationApplicationConfiguration.class) // It's proper to have @Import here. See /32-jdbc-autoconfig-solution/src/main/java/rewards/RewardsApplication.java for reference.
@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
        )
public class JavaBasedAnnotationApplication {
    
	private static Logger logger = (Logger)LoggerFactory.getLogger(JavaBasedAnnotationApplication.class);
	
    @Autowired
    private Environment environment;

    public static void main(String[] args) {
        logger.setLevel(Level.DEBUG);

        
		ApplicationContext context = SpringApplication.run(JavaBasedAnnotationApplication.class, args);
		Integer i = context.getBean ( "someInteger", Integer.class );
		System.out.println("i = " + i);
		
		AcmeInfo info = context.getBean ( AcmeInfo.class );
		logger.info("info = " + info);
		

	}
	
    @Bean
    ApplicationRunner applicationRunner(Environment environment) {
        return args -> {
            logger.info("ACME_TIMEOUT = " + this.environment.getProperty("ACME_TIMEOUT"));
            logger.info("PYTHON_HOME = " + this.environment.getProperty("PYTHON_HOME"));
        };
    }
}
