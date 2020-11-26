package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Customer;
import dmacc.beans.CustomerReservation;
import dmacc.beans.Flight;

public class BeanConfiguration {
	
	@Bean
	public Customer customer() {
		Customer bean = new Customer();
		return bean;
	}
	
	//would other classes need to be autowired into Customer.java?
	@Bean
	public CustomerReservation reservation() {
		CustomerReservation bean = new CustomerReservation();
		return bean;
	}
	@Bean
	public Flight flight() {
		Flight bean = new Flight();
		return bean;
	}
	

}
