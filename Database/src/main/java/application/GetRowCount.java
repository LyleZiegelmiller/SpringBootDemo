package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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
    

    @GetMapping("/accounts/totalNumber/json")
    public ResponseEntity < JsonWrapper > testNumberOfAccountAsJson() throws Exception {
        long count = jdbcTemplate.queryForObject(QUERY, Long.class);
        logger.info ( "testNumberOfAccountAsJson: ljz_cust_data has " + count + " rows." );
        
        return ResponseEntity
                .ok ()
                .contentType ( MediaType.APPLICATION_JSON )
                .body ( new JsonWrapper(count, new Date().getTime ()) );
    }
}

@ResponseBody
class JsonWrapper{
    // Fields have to be public for the Json converter to work.
    public long count;
    public long currentTime;
    
    public JsonWrapper (long count, long currentTime)
    {
        this.count = count;
        this.currentTime = currentTime;
    }
}
