package misc;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("someOtherClass")
public class SomeOtherClass
{
    private Logger logger;
    private static AtomicInteger instantiationCount = new AtomicInteger(0);
    
    SomeOtherClass (){
        logger = LoggerFactory.getLogger ( getClass () );
        instantiationCount.incrementAndGet ();
    }

    public void printDescription() {
        logger.info ( "This class ( " + this.getClass ().getSimpleName () + " ) will be accessed via context.getBean." );
        logger.info ( "instantiationCount = " + instantiationCount );
    }
}
