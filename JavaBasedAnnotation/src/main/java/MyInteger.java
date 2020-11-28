import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("file:src/main/resources/app.properties")
// C:\cygwin64\home\lylez\workspace\JavaSpringBootExperimentation\JavaBasedAnnotation   \src\main\resources\app.properties
// C:\cygwin64\home\lylez\workspace\JavaSpringBootExperimentation\JavaBasedAnnotation   \src\main\java\MyInteger.java
public class MyInteger
{
    private int i;
    
//    @Autowired - optional when it's the only constructor
    public MyInteger (@Value ("${myInt}") Integer i)
    {
        this.i = i.intValue ();
    }
    public Integer getMyInteger() {
        return Integer.valueOf ( i );
    }
}
