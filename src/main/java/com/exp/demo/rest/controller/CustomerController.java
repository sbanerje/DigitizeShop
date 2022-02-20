package com.exp.demo.rest.controller;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.exp.demo.entity.Customer;
import com.exp.demo.repository.CustomerRepository;

@RestController
public class CustomerController {

	private final CustomerRepository repository;

	CustomerController(CustomerRepository repository) {
	    this.repository = repository;
	  }


	  @GetMapping("/customers")
	  CollectionModel<Customer> getCustomers() {
		  List<Customer>  customers =  repository.findAll();
		  for(Customer cust : customers) {
			  Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class).getCustomer(cust.getId())).withSelfRel();
			  cust.add(link);
		  }
		  
		  Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class).getCustomers()).withSelfRel();
		    CollectionModel<Customer> result = CollectionModel.of(customers, link);
		    return result;
	  }
	  
	  @GetMapping("/customers/{id}")
	  Customer getCustomer(@PathVariable Long id) {
	    
	    Customer cust =  repository.findById(id)
	      .orElseThrow(() -> new RuntimeException(String.valueOf(id)));
	    Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class).getCustomer(id)).withSelfRel();
		  cust.add(link);
		  
		  Link linkall = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class).getCustomers()).withRel("allCustomers");
		  cust.add(linkall);
		  return cust;
	    
	  }
	  
	  
}
