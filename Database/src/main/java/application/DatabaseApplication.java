package application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import misc.SomeOtherClass;


/*
 * The exclude below suppresses Spring Boot Security
 */
@SpringBootApplication(scanBasePackages = {"configure", "application", "misc", "application.jpa"}, exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
        )
public class DatabaseApplication
{
    private final Logger logger = LoggerFactory.getLogger(DatabaseApplication.class);
    
//    @Autowired
//    DatabaseController getRowCount;

    
    public static void main ( String [] args )
    {
        ApplicationContext applicationContext = SpringApplication.run ( DatabaseApplication.class, args );
        
//        SomeOtherClass someOtherClass;
//
//        for ( int i = 0; i < 5; i++){
//            someOtherClass = applicationContext.getBean("someOtherClass", SomeOtherClass.class);
//            someOtherClass.printDescription();
//        }
//
//        for ( int i = 0; i < 5; i++){
//            someOtherClass = applicationContext.getBean("prototypeClass", SomeOtherClass.class);
//            someOtherClass.printDescription();
//        }
    }
    
//    @Component
//    public final class QueryDatabaseCountRunner implements CommandLineRunner {
//        
//        @Autowired
//        private DatabaseController getRowCount;
//
//        @Override
//        public void run(String... args) throws Exception {
//            
//            logger.debug("This is a debug message");
//            logger.info("This is an info message");
//            logger.warn("This is a warn message");
//            logger.error("This is an error message");
//            
//            long i = getRowCount.testNumberOfAccount();
//            logger.info ( "count from QueryDatabaseCountRunner = " + i );
//
//        }
//    }
}
