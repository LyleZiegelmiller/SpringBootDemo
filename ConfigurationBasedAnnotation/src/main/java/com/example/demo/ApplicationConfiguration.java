package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("file:config/local.properties")
public class ApplicationConfiguration
{
    @Autowired
    Environment env;
    
    @Bean
    public TestBean testBean() {
        TestBean testBean = new TestBean();
        String value = env.getProperty("key1");
        testBean.setName(value);
        return testBean;
    }    
    
}
