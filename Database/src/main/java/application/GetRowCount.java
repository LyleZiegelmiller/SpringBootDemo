package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class GetRowCount
{
    protected final Logger logger;
    
    public static final String QUERY = "SELECT count(*) FROM ljz_cust_data";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    GetRowCount(){
        logger = LoggerFactory.getLogger(getClass());
    }

    @GetMapping("/accounts/totalNumber")
    public long testNumberOfAccount() throws Exception {

        long count = jdbcTemplate.queryForObject(QUERY, Long.class);

        logger.info ( "ljz_cust_data has " + count + " rows." );
        
        return count;
    }
}
