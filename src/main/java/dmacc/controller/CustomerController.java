package dmacc.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dmacc.beans.Customer;
import dmacc.repository.CustomerRepository;

@Controller
public class CustomerController {

	@Autowired
	CustomerRepository custRepo;

	// added this below to see if it works outside of webcontroller
	@GetMapping("/customerList")
	public String viewCustomer(Model model) {
		if (custRepo.findAll().isEmpty()) {
			return addNewCustomer(model);
		}
		model.addAttribute("customers", custRepo.findAll());
		return "customerList";
	}

	@GetMapping("/input")
	public String addNewCustomer(Model model) {
		Customer c = new Customer();
		model.addAttribute("newCustomer", c);
		return "input";
	}

	// method viewAllCustomers doesn't work in this controller
	@PostMapping("/input")
	public String addNewCustomer(@ModelAttribute Customer c, Model model) {
		custRepo.save(c);
		return viewCustomer(model);
	}

	@GetMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable("id") long id, Model model) {
		Customer c = custRepo.findById(id).orElse(null);
		custRepo.delete(c);
		return viewCustomer(model);
	}

	@GetMapping("/edit/{id}")
	public String showUpdateCustomer(@PathVariable("id") long id, Model model) {
		Customer c = custRepo.findById(id).orElse(null);
		model.addAttribute("newCustomer", c);
		return "input";
	}

	@PostMapping("/update/{id}")
	public String updateCustomer(@PathVariable("id") long id, Model model, Customer customer) {
		Customer myCust = custRepo.findById(id).orElse(null);
		myCust.setFirstName(customer.getFirstName());
		myCust.setLastName(customer.getLastName());
		custRepo.save(myCust);
		return viewCustomer(model);
	
	}

}
