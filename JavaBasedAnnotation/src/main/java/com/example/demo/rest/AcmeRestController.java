package com.example.demo.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties ( {AcmeInfo.class, EnvInfo.class} )
public class AcmeRestController
{
    private final Logger logger = LoggerFactory.getLogger ( AcmeRestController.class );

    @Autowired
    private AcmeInfo info; // This can't be an argument to getAcmeInfo.
    
    @Autowired
    private Environment env;
    
    @Autowired
    private EnvInfo envInfo;
    
    private @Value("${JAVA_HOME}") String java_home;

    /**
     * @formatter:off

    $ curl -H 'Accept:application/json' http://localhost:8080/acme
    {"host":"192.168.1.42","port":8080,"logdir":"/logs","timeout":2000}
    $ curl -H 'Accept:application/xml' http://localhost:8080/acme
    <AcmeInfo><host>192.168.1.42</host><port>8080</port><logdir>/logs</logdir><timeout>2000</timeout></AcmeInfo>
    
     */

    @GetMapping("/acme")
    public AcmeInfo getAcmeInfo() {
        
        logger.info ( "Inside getAcmeInfo, info = " + info );
        
        // Automatically converts to either JSON or XML.
        return info;
    }
    
    @GetMapping("/root")
    public String getRoot() {
        logger.info ( "root = " +  envInfo.getRoot ());
        
        return envInfo.getRoot ();
    }
    
    @GetMapping("/timeout")
    public Integer getTimeout() {
        
        String timeoutStr = env.getProperty ( "ACME_TIMEOUT" ); //"ACME_CLIENT_TIMEOUT" );
        
        logger.info ( "timeoutStr = " + timeoutStr );
        
        if ( timeoutStr == null)
            return null;
        
        Integer timeout = Integer.valueOf ( timeoutStr );
        
        return timeout;
    }
}
