package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Flight;
import dmacc.repository.FlightRepository;

@Controller
public class FlightController {
	
	@Autowired
	FlightRepository flightRepo;
	
	@GetMapping("/flightList")
	public String viewAllFlights(Model model) {
		model.addAttribute("flights", flightRepo.findAll());
		return "flightList";
	}
	
	@GetMapping("/inputFlight")
	public String addNewFlight(Model model) {
		Flight f = new Flight();
		model.addAttribute("newFlight", f);
		return "inputFlight";
	}
	
	@PostMapping("inputFlight")
	public String addNewFlight(@ModelAttribute Flight f, Model model) {
		flightRepo.save(f);
		return viewAllFlights(model);
	}
	@PostMapping("/updateFlight/{id}")
	public String updateFlights(@PathVariable("id") long id, Model model, Flight flight) {
		if(id > 0) {
			Flight newFlight = flightRepo.findById(id).orElse(null);
			newFlight.setDepartCity(flight.getDepartCity());
			newFlight.setDestinCity(flight.getDestinCity());
			newFlight.setCapacity(flight.getCapacity());
			newFlight.setSeatCostAmt(flight.getSeatCostAmt());
			flightRepo.save(newFlight);
		}else {
			flightRepo.save(flight);
		}
		return viewAllFlights(model);
	}
}
