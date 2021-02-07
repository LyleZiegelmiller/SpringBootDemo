package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("file:config/local.properties")
public class SomeClass
{
    @Autowired
    TestBean testBean;
    
    @Autowired
    Environment env;
    
    void printProperty() {
        System.out.println("testBean.getProperty () = " +  testBean.getProperty ());
    }
    
    void setBeanProperty() {
        String value = env.getProperty("key1");
        //value = 
        testBean.setProperty(value);
    }
}
