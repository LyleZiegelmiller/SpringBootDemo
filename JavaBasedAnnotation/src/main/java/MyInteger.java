

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("file:src/main/resources/application.properties")
public class MyInteger
{
    private int i;
    
    @Autowired
    public MyInteger (@Value ("${myInt}") Integer i)
    {
        this.i = i.intValue (); // Integer.valueOf ( i );
    }
    public Integer getMyInteger() {
        return Integer.valueOf ( i );
    }
}
