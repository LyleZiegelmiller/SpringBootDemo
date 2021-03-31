package application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@EnableAutoConfiguration
@SpringBootTest
//@JdbcTest
@Sql({"classpath:ljz_schema.sql", "classpath:ljz_data.sql"})
class DatabaseControllerTest
{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private DatabaseController controller;
    
    @BeforeEach
    void setUp () throws Exception
    {
    }

    @Test
    void testUpdateName()
    {
        
        long count = jdbcTemplate.queryForObject("select count(*) from ljz_cust_data", Long.class);
        assertEquals ( 2L, count );
        
        // Begin code based on accounts.web.AccountControllerTests.setupFakeRequest(String)
        // in /38-rest-ws-solution/src/test/java/accounts/web/AccountControllerTests.java.
        String requestURI = "/accounts/changeName/Richard%20Green/John%20Robbins";

        // We can use Spring's convenient mock implementation. Defaults to
        // localhost in the URL. Since we only need the URL, we don't need
        // to setup anything else in the request.
        MockHttpServletRequest request = new MockHttpServletRequest("PUT", requestURI);
        
        // Puts the fake request in the current thread for the
        // ServletUriComponentsBuilder to initialize itself from later.
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        // End code based on accounts.web.AccountControllerTests.setupFakeRequest(String)
        // in /38-rest-ws-solution/src/test/java/accounts/web/AccountControllerTests.java.
        
        // Now make the actual call to the controller in /Database/src/main/java/application/DatabaseController.java.
        
        controller.updateName ( "Richard%20Green", "John%20Robbins" );
        
        count = jdbcTemplate.queryForObject("select count(*) from ljz_cust_data where name = 'John Robbins'", Long.class);
        
        assertEquals ( 1L, count );
    }
}
