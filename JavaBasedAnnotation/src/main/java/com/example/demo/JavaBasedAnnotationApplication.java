package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import com.example.demo.rest.AcmeInfo;

//@EnableConfigurationProperties(ConfigurationProperties.class)

@Import (JavaBasedAnnotationApplicationConfiguration.class) // It's proper to have @Import here. See /32-jdbc-autoconfig-solution/src/main/java/rewards/RewardsApplication.java for reference.
@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
        )
public class JavaBasedAnnotationApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JavaBasedAnnotationApplication.class, args);
		Integer i = context.getBean ( "someInteger", Integer.class );
		System.out.println("i = " + i);
		
		AcmeInfo info = context.getBean ( AcmeInfo.class );
		System.out.println("info = " + info);
	}
}
