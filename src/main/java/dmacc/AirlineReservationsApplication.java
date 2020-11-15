package dmacc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import dmacc.beans.Customer;
import dmacc.beans.CustomerReservation;
import dmacc.beans.Flight;
import dmacc.controller.BeanConfiguration;
import dmacc.repository.CustomerRepository;
import dmacc.repository.CustomerReservationRepository;
import dmacc.repository.FlightRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
public class AirlineReservationsApplication{

	public static void main(String[] args) {
		SpringApplication.run(AirlineReservationsApplication.class, args);
	}
		/* -lx
		//ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		//Customer c = appContext.getBean("customer", Customer.class);
		//System.out.println(c.toString());
		
		@Autowired
		CustomerRepository custRepo;
		@Autowired
		FlightRepository flightRepo;
		@Autowired
		CustomerReservationRepository crRepo;

		@Override
		public void run(String... args) throws Exception {
			System.out.println("hello");
			
			ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
			
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
			
			List<CustomerReservation> allReservations = crRepo.findAll();
			for(CustomerReservation reservation: allReservations) {
				System.out.println(reservation.toString());
			}
			//((AbstractApplicationContext) appContext).close();
			
			List<Flight> allFlights = flightRepo.findAll();
			for(Flight destination: allFlights) {
				System.out.println(destination.toString());
			}
			//((AbstractApplicationContext) appContext).close();
			
			List<Customer> allCustomers = custRepo.findAll();
			for(Customer people: allCustomers) {
				System.out.println(people.toString());
				
			}
			((AbstractApplicationContext) appContext).close();

		}
		*/
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

