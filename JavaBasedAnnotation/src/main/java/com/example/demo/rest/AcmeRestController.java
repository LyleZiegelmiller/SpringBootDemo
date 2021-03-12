package com.example.demo.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties(AcmeInfo.class)
public class AcmeRestController
{
    private final Logger logger = LoggerFactory.getLogger(AcmeRestController.class);
    
    @GetMapping("/acme")
    public AcmeInfo getAcmeInfo(@Autowired AcmeInfo info) {
        
        logger.info ( "Inside getAcmeInfo, info = " + info );
        
        return info;
    }
    
}
