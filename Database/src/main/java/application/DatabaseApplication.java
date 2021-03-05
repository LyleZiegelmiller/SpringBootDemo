package application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication(scanBasePackages = {"configure", "application"})
public class DatabaseApplication
{
    private final Logger logger = LoggerFactory.getLogger(DatabaseApplication.class);
    
    @Autowired
    GetRowCount getRowCount;
    
    public static void main ( String [] args )
    {
        // TODO Auto-generated method stub
        SpringApplication.run ( DatabaseApplication.class, args );
    }
    
    @Component
    public final class QueryDatabaseCountRunner implements CommandLineRunner {
        
        @Autowired
        private GetRowCount getRowCount;

        @Override
        public void run(String... args) throws Exception {
            getRowCount.testNumberOfAccount();
        }
    }
}
