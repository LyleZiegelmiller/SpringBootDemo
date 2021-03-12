package com.example.demo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import( {MyInteger.class, DerivedFrom_MyInteger.class} )
public class JavaBasedAnnotationApplicationConfiguration
{
    // See https://www.logicbig.com/tutorials/spring-framework/spring-core/javaconfig-methods-inter-dependency.html
    @Bean public Integer someInteger(@Qualifier("MyInteger") MyInteger i) {
        return Integer.valueOf ( i.getMyInteger () );
    }
}
