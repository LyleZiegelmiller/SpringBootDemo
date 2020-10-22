import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JavaBasedAnnotationApplication {

	public static void main(String[] args) {
	    
		ApplicationContext context = SpringApplication.run(ApplicationConfiguration.class, args);
		
		Integer i = context.getBean ( "someInteger", Integer.class );
		
		System.out.println("i = " + i);
	}

}
