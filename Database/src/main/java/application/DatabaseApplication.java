package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import application.config.SomeOtherClass;

@SpringBootApplication(scanBasePackages = {"configure", "application.config"})
public class DatabaseApplication
{
    @Autowired
    SomeOtherClass someOtherClass;
    
    public static void main ( String [] args )
    {
        // TODO Auto-generated method stub
        SpringApplication.run ( DatabaseApplication.class, args );

    }

}
