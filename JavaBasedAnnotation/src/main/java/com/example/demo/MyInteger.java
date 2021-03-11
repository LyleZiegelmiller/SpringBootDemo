package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@PropertySource("file:src/main/resources/app.properties")
// C:\cygwin64\home\lylez\workspace\JavaSpringBootExperimentation\JavaBasedAnnotation   \src\main\resources\app.properties
// C:\cygwin64\home\lylez\workspace\JavaSpringBootExperimentation\JavaBasedAnnotation   \src\main\java\MyInteger.java
@Primary
public class MyInteger
{
    private int i;
    
    //@Autowired //- optional when it's the only constructor
    public MyInteger (@Value ("${myInt}") Integer i) // In app.properties, myInt=5
    {
        this.i = i.intValue ();
    }
    public Integer getMyInteger() {
        return Integer.valueOf ( i );
    }
}
