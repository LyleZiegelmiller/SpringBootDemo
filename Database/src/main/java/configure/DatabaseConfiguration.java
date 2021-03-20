package configure;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

@Configuration
public class DatabaseConfiguration
{
    @Bean//(name = "ljzDataSource")
    public DataSource dataSource() {
        return (new EmbeddedDatabaseBuilder()) //
                .addScript("classpath:ljz_schema.sql") //
                .addScript("classpath:ljz_data.sql").build();
    }
}
