package application;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseController
{
    protected final Logger logger;

    public static final String QUERY = "SELECT count(*) FROM ljz_cust_data";
    private JdbcTemplate jdbcTemplate;

    /* Because this is the only constructor, the use of @Autowired is unnecessary. */
    DatabaseController (JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
        logger = LoggerFactory.getLogger ( getClass () );
    }

    public long testNumberOfAccount () throws Exception
    {
        long count = jdbcTemplate.queryForObject ( QUERY, Long.class );
        logger.info ( "ljz_cust_data has " + count + " rows." );
        return count;
    }

    @GetMapping (value = "/accounts/totalNumberSpecifyType/{type}")
    public ResponseEntity < ResponseWrapper > getNumberOfAccountByType (
                                            @PathVariable ("type") String type ) throws Exception
    {

        // Can invoke with curl. For example:
        // curl  -i -u user:f971c660-63ce-4a75-a8b1-b24feb71fb6b  http://localhost:8080/accounts/totalNumber/json

        long count = jdbcTemplate.queryForObject ( QUERY, Long.class );
        logger.info ( "testNumberOfAccountAsJson: ljz_cust_data has " + count + " rows." );

        MediaType desiredType;

        if ( type.equalsIgnoreCase ( "JSON" ) )
            desiredType = MediaType.APPLICATION_JSON;
        else if ( type.equalsIgnoreCase ( "XML" ) )
            desiredType = MediaType.APPLICATION_XML;
        else
            return ResponseEntity.badRequest ().body(null);
        
        return ResponseEntity.ok ().contentType ( desiredType ).body (
                                                new ResponseWrapper ( count, new Date ().getTime () ) );
    }

    @GetMapping (value = "/accounts/totalNumber/json", produces = { MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity < ResponseWrapper > getNumberOfAccountAsJson () throws Exception
    {

        // Can invoke with curl. For example:
        // curl  -i -u user:7ef6ce65-e9a9-4f26-b82d-151f51a5f9cf -H 'Accept: application/xml' http://localhost:8080/accounts/totalNumber/xml

        long count = jdbcTemplate.queryForObject ( QUERY, Long.class );
        logger.info ( "testNumberOfAccountAsJson: ljz_cust_data has " + count + " rows." );

        return ResponseEntity.ok ().contentType ( MediaType.APPLICATION_JSON ).body (
                                                new ResponseWrapper ( count, new Date ().getTime () ) );
    }

    @GetMapping (value = "/accounts/totalNumber/xml", produces = {
            MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity < ResponseWrapper > getNumberOfAccountAsXml () throws Exception
    {

        // Can invoke with curl. For example:
        // curl -i -u user:7ef6ce65-e9a9-4f26-b82d-151f51a5f9cf -H 'Accept: application/xml' http://localhost:8080/accounts/totalNumber/xml

        long count = jdbcTemplate.queryForObject ( QUERY, Long.class );
        logger.info ( "getNumberOfAccountAsXml: ljz_cust_data has " + count + " rows." );

        return ResponseEntity.ok ().contentType ( MediaType.APPLICATION_XML ).body (
                                                new ResponseWrapper ( count, new Date ().getTime () ) );
    }

    @GetMapping (value = "/accounts/totalNumber", produces = { MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE })
    public ResponseWrapper getNumberOfAccount ()
    {

        // curl -i -u user:1e8e3b30-2193-422a-85bc-bc5597a6d560 -H 'Accept: application/xml' http://localhost:8080/accounts/totalNumber
        // curl -i -u user:1e8e3b30-2193-422a-85bc-bc5597a6d560 -H 'Accept: application/json' http://localhost:8080/accounts/totalNumber
        //
        long count = jdbcTemplate.queryForObject ( QUERY, Long.class );
        logger.info ( "getNumberOfAccount: ljz_cust_data has " + count + " rows." );

        return new ResponseWrapper ( count, new Date ().getTime () );
    }
}

@ResponseBody
class ResponseWrapper
{
    // Fields have to be public for the converters to work.
    public long count;
    public long currentTime;

    public ResponseWrapper ( long count, long currentTime )
    {
        this.count = count;
        this.currentTime = currentTime;
    }
}
