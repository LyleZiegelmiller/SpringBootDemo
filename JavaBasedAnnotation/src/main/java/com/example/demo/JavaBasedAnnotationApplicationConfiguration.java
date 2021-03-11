package com.example.demo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import( {MyInteger.class, MyOtherInteger.class} )
//@Import( MyInteger.class )
public class JavaBasedAnnotationApplicationConfiguration
{
    @Bean public Integer someInteger(MyInteger i) {
        return Integer.valueOf ( i.getMyInteger () );
    }
}
