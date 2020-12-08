package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Customer;
import dmacc.beans.CustomerReservation;
import dmacc.beans.Flight;
import dmacc.repository.CustomerRepository;
import dmacc.repository.CustomerReservationRepository;
import dmacc.repository.FlightRepository;

@Controller
public class WebController {
	//added the mapping below to get to the employee & customer links
	@Autowired
	CustomerRepository custRepo;
	
	@Autowired
	FlightRepository flightRepo;
	
	@Autowired
	CustomerReservationRepository crRepo;
	
	@GetMapping("/customer")
	public String viewAllCustomers(Model model) {
		Customer c = new Customer();
		model.addAttribute("newCustomer", c);
		CustomerReservation cr = new CustomerReservation();
		model.addAttribute("newReservation", cr);
		Flight f = new Flight();
		model.addAttribute("newFlight", f);
		return "customer";
		
	}
	
	
	/*//added this to the CustomerController - method viewallCustomers doesnt work there
	@PostMapping("/input")
	public String addNewCustomer(@ModelAttribute Customer c, Model model) {
		custRepo.save(c);
		return viewAllCustomers(model);
	}*/
	@GetMapping("/employee")
	public String viewEmployee(Model model) {
		//added all the classes just in case
		//feel free to change info below
		Customer c = new Customer();
		model.addAttribute("newCustomer", c);
		CustomerReservation cr = new CustomerReservation();
		model.addAttribute("newReservation", cr);
		Flight f = new Flight();
		model.addAttribute("newFlight", f);
		return "employee";
	}

	/**
	@GetMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable("id") long id, Model model) {
		Customer c = custRepo.findById(id).orElse(null);
		custRepo.delete(c);
		return viewAllCustomers(model);
	}
	*/
		
	
}
