package com.example.demo.rest;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="perl.local.lib")
public class EnvInfo
{
    // PERL_LOCAL_LIB_ROOT=/home/lylez/perl5
    private String ROOT;

    /**
     * @return the root
     */
    public String getRoot ()
    {
        return ROOT;
    }

    /**
     * @param root the root to set
     */
    public void setRoot ( String root )
    {
        this.ROOT = root;
    }

}
