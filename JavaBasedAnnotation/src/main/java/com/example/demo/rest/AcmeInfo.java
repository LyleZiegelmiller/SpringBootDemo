package com.example.demo.rest;

import org.springframework.boot.context.properties.ConfigurationProperties;

//@Component
@ConfigurationProperties(prefix="acme.client")
public class AcmeInfo
{
    public String host;
    public int port;
    public String logdir;
    public int timeout;
    /**
     * @return the host
     */
    public String getHost ()
    {
        return host;
    }
    /**
     * @param host the host to set
     */
    public void setHost ( String host )
    {
        this.host = host;
    }
    /**
     * @return the port
     */
    public int getPort ()
    {
        return port;
    }
    /**
     * @param port the port to set
     */
    public void setPort ( int port )
    {
        this.port = port;
    }
    /**
     * @return the logdir
     */
    public String getLogdir ()
    {
        return logdir;
    }
    /**
     * @param logdir the logdir to set
     */
    public void setLogdir ( String logdir )
    {
        this.logdir = logdir;
    }
    /**
     * @return the timeout
     */
    public int getTimeout ()
    {
        return timeout;
    }
    /**
     * @param timeout the timeout to set
     */
    public void setTimeout ( int timeout )
    {
        this.timeout = timeout;
    }
    
    @Override
    public String toString() {
        return "host = " + host + " port = " + port + " logdir = " + logdir + " timeout = " + timeout;
    }
}
