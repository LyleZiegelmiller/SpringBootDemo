package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class TestBean
{
    private String property;

    public void setProperty ( String property )
    {
        this.property = property;
    }

    public String getProperty ()
    {
        return property;
    }
}
