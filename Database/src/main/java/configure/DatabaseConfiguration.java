package configure;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

@Configuration
public class DatabaseConfiguration
{
    @Bean(name = "ljzDataSource")
    public DataSource dataSource() {
        return (new EmbeddedDatabaseBuilder()) //
                .addScript("classpath:schema.sql") //
                .addScript("classpath:data.sql").build();
    }
}
