

import org.springframework.context.annotation.Configuration;

@Configuration
public class MyInteger
{
    public Integer getMyInteger() {
        return Integer.valueOf ( 9 );
    }
}
