package dmacc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirlineReservationsApplication{

	public static void main(String[] args) {
		SpringApplication.run(AirlineReservationsApplication.class, args);
	}

	/**
	 * 
	 * 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import dmacc.beans.Customer;
import dmacc.beans.CustomerReservation;
import dmacc.beans.Flight;
import dmacc.repository.CustomerRepository;
import dmacc.repository.CustomerReservationRepository;
import dmacc.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

	 @SpringBootApplication
public class AirlineReservationsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AirlineReservationsApplication.class, args);
	}
	@Autowired
	CustomerRepository custRepo;
	@Autowired
	FlightRepository flightRepo;
	@Autowired
	CustomerReservationRepository crRepo;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("hello");

		
		// Update customer table
		Customer c = new Customer();
		c.setFirstName("Steve");
		c.setLastName("Johnson");
		custRepo.save(c);

		// Update flight table
		Flight f = new Flight();
		f.setCapacity(14);
		f.setDepartCity("Des Moines");
		f.setDestinCity("Pittsburg");
		f.setSeatCostAmt(149);
		flightRepo.save(f);

	
		CustomerReservation cr = new CustomerReservation();
		cr.setCustId(6);
		cr.setFlightId(5);
		cr.setSeatIdentifierText("4A");
		crRepo.save(cr);


	}
 */
}
