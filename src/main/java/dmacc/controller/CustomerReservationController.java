package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.CustomerReservation;
import dmacc.repository.CustomerReservationRepository;

@Controller
public class CustomerReservationController {

	@Autowired
	CustomerReservationRepository crRepo;
	
	@GetMapping("/reservation")
	public String viewAllReservations(Model model) {
		if(crRepo.findAll().isEmpty()) {
			return addNewReservation(model);
		}
		model.addAttribute("reservations", crRepo.findAll());
		return "reservation";
	}
	
	@GetMapping("/inputReservation")
	public String addNewReservation(Model model) {
		CustomerReservation cres = new CustomerReservation();
		model.addAttribute("newReservation", cres);
		return "inputRes";
	}
	
	@PostMapping("/inputReservation")
	public String addNewReservation(@ModelAttribute CustomerReservation cres, Model model) {
		crRepo.save(cres);
		return viewAllReservations(model);
	}
	
	@GetMapping("/editReservation/{id}")
	public String showUpdateReservation(@PathVariable("id") long id, Model model) {
		CustomerReservation cres = new CustomerReservation();
		model.addAttribute("newReservation", cres);
		return "inputRes";
	}
	
	@PostMapping("/updateReservation/{id}")
	public String reviseReservation(CustomerReservation cres, Model model) {
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
