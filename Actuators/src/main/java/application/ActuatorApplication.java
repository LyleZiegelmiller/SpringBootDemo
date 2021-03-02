package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication //(exclude = { SecurityAutoConfiguration.class })
public class ActuatorApplication
{
    public static void main ( String [] args )
    {
        // TODO Auto-generated method stub
        SpringApplication.run ( ActuatorApplication.class, args );

    }

}
