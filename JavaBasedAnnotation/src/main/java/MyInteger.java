import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyInteger
{
    private int i;
    
    @Autowired
    public MyInteger (@Value ("${myInt}") Integer i)
    {
        this.i = i.intValue ();
    }
    public Integer getMyInteger() {
        return Integer.valueOf ( i );
    }
}
