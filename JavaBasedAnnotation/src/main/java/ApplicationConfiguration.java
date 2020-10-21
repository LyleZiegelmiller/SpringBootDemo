

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MyInteger.class)
public class ApplicationConfiguration
{
    @Bean public Integer someInteger(MyInteger i) {
        return Integer.valueOf ( i.getMyInteger () );
    }
}
