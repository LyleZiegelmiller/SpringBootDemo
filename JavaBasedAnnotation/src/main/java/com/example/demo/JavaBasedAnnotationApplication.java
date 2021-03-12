package com.example.demo;


import org.slf4j.Logger;
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
    
	private static Logger logger = LoggerFactory.getLogger(JavaBasedAnnotationApplication.class);
	
    @Autowired
    private Environment environment;

    public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JavaBasedAnnotationApplication.class, args);
		Integer i = context.getBean ( "someInteger", Integer.class );
		System.out.println("i = " + i);
		
		AcmeInfo info = context.getBean ( AcmeInfo.class );
		logger.info("info = " + info);
		

	}
	
    @Bean
    ApplicationRunner applicationRunner(Environment environment) {
        return args -> {
            logger.info("JAVA_HOME = " + this.environment.getProperty("JAVA_HOME"));
        };
    }
}
