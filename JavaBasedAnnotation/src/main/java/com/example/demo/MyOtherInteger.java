package com.example.demo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("file:src/main/resources/app.properties")
// C:\cygwin64\home\lylez\workspace\JavaSpringBootExperimentation\JavaBasedAnnotation   \src\main\resources\app.properties
// C:\cygwin64\home\lylez\workspace\JavaSpringBootExperimentation\JavaBasedAnnotation   \src\main\java\MyInteger.java
@Qualifier("MyOtherInteger") // See https://www.logicbig.com/tutorials/spring-framework/spring-core/javaconfig-methods-inter-dependency.html
public class MyOtherInteger extends MyInteger
{
    private int i;
    
//    @Autowired - optional when it's the only constructor
    public MyOtherInteger (@Value ("${myInt}") Integer i) // In app.properties, myInt=5
    {
        super(i);
        this.i = i.intValue () * 2;
    }
    public Integer getMyInteger() {
        return Integer.valueOf ( i );
    }
}
