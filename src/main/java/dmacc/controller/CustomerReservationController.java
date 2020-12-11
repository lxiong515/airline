package dmacc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.CustomerReservation;

import dmacc.repository.CustomerRepository;
import dmacc.repository.CustomerReservationRepository;
import dmacc.repository.FlightRepository;

@Controller
public class CustomerReservationController {

	@Autowired
	CustomerReservationRepository crRepo;
	@Autowired
	CustomerRepository custRepo;
	@Autowired
	FlightRepository flightRepo;

	@GetMapping("/reservation")
	public String viewAllReservations(Model model) {
		if (crRepo.findAll().isEmpty()) {
			return addNewReservation(model);
		}
		model.addAttribute("reservations", crRepo.findAll());
		return "reservation";
	}

	@GetMapping("/inputReservation")
	public String addNewReservation(Model model) {
		CustomerReservation cres = new CustomerReservation();
		model.addAttribute("newReservation", cres);
		model.addAttribute("flights", flightRepo.findAll());
		model.addAttribute("customers", custRepo.findAll());
		return "inputRes";
	}

	@PostMapping("/inputReservation/{id}")
	public String addReservation(@ModelAttribute CustomerReservation cres, @PathVariable("id") long id, Model model) {
		List<CustomerReservation> reservations = crRepo.findByFlight_Id(cres.getFlight().getId());
		String[] seatsTaken = new String[reservations.size()];
		for (int i = 0; i < reservations.size(); i++) {
			seatsTaken[i] = reservations.get(i).getSeatIdentifierText();
		}
		System.out.println(id);
		model.addAttribute("seatsTaken", seatsTaken);
		model.addAttribute("newReservation", cres);
		model.addAttribute("id", id);
		return "/pickSeat";
	}

	@GetMapping("/editReservation/{id}")
	public String showUpdateReservation(@PathVariable("id") long id, Model model) {
		CustomerReservation cres = crRepo.findById(id).orElse(null);
		model.addAttribute("newReservation", cres);
		model.addAttribute("flights", flightRepo.findAll());
		model.addAttribute("customers", custRepo.findAll());
		return "inputRes";
	}

	@PostMapping("/updateReservation/{id}")
	public String reviseReservation(CustomerReservation cres, @PathVariable("id") long id, Model model) {
		//to avoid the bean reseting the id when it is passed
		cres.setId(id);
		crRepo.save(cres);
		return viewAllReservations(model);
	}

	@GetMapping("/deleteReservation/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		CustomerReservation cres = crRepo.findById(id).orElse(null);
		crRepo.delete(cres);
		return viewAllReservations(model);
	}

}
