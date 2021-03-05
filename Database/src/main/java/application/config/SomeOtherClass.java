package application.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SomeOtherClass
{
    public SomeOtherClass (DataSource ljzDataSource)
    {
        System.out.println("Inside SomeOtherClass constructor");
    }

}
