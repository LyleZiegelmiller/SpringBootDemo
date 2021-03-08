package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * The exclude below suppresses Spring Boot Security
 */
@SpringBootApplication(scanBasePackages = {"configure", "application"}, exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
        )
@SpringBootApplication
public class ActuatorApplication
{
    public static void main ( String [] args )
    {
        // TODO Auto-generated method stub
        SpringApplication.run ( ActuatorApplication.class, args );
    }

}
