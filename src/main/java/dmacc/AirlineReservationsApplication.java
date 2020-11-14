package dmacc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//import from beans and controller here

@SpringBootApplication
public class AirlineReservationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlineReservationsApplication.class, args);
	}

}
