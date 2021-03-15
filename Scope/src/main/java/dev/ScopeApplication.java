package dev;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication( exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
        )
public class ScopeApplication
{
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

}
