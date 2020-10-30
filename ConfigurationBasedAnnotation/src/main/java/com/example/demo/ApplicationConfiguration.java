package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration

@ComponentScan("com.example.demo")
public class ApplicationConfiguration
{
    ApplicationConfiguration (@Autowired SomeClass obj){
    
        //obj.setBeanProperty ();
        obj.printProperty ();
    }
}
