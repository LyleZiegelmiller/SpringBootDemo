About all this project really does is to add

management.endpoints.jmx.exposure.exclude=

and

management.endpoints.web.exposure.include=*

to application.properties, and adds these lines

@SpringBootApplication(scanBasePackages = {"configure", "application"}, exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
        )
        
above the ActuatorApplication class.

That's all it takes to make the actuators available - see http://www.localhost:8080/actuator, and
to suppress Spring Security.
