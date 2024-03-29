package com.example.demo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource("file:src/main/resources/app.properties")
// C:\cygwin64\home\lylez\workspace\JavaSpringBootExperimentation\JavaBasedAnnotation   \src\main\resources\app.properties
// C:\cygwin64\home\lylez\workspace\JavaSpringBootExperimentation\JavaBasedAnnotation   \src\main\java\MyInteger.java
//@Primary
@Qualifier("MyInteger")
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
