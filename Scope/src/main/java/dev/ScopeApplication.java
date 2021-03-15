package dev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication( exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
        )
public class ScopeApplication
{
    private final Logger logger = LoggerFactory.getLogger(ScopeApplication.class);
    
    public static void main ( String [] args )
    {
        ApplicationContext applicationContext = SpringApplication.run ( ScopeApplication.class );

        SomeOtherClass someOtherClass;

        for ( int i = 0; i < 5; i++ )
        {
            someOtherClass = applicationContext.getBean ( "someOtherClass", SomeOtherClass.class );
            someOtherClass.printDescription ();
        }

        for ( int i = 0; i < 5; i++ )
        {
            someOtherClass = applicationContext.getBean ( "prototypeClass", SomeOtherClass.class );
            someOtherClass.printDescription ();
        }

    }

    @Component
    public final class QueryDatabaseCountRunner implements CommandLineRunner {
        
        @Override
        public void run(String... args) throws Exception {
            logger.debug("This is a debug message");
            logger.info("This is an info message");
            logger.warn("This is a warn message");
            logger.error("This is an error message");
        }
    }
}
