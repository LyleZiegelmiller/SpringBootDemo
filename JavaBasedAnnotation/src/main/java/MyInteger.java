import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("file:src/main/resources/app.properties")
public class MyInteger
{
    private int i;
    
//    @Autowired

    public MyInteger (@Value ("${myInt}") Integer i)
    {
        this.i = i.intValue ();
    }
    public Integer getMyInteger() {
        return Integer.valueOf ( i );
    }
}
