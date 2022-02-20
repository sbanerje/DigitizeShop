package com.exp.demo.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exp.demo.entity.Organization;
import com.exp.demo.repository.OrganizationRepository;

//@RestController
public class OrganizationController {
	

	  private final OrganizationRepository repository;

	  OrganizationController(OrganizationRepository repository) {
	    this.repository = repository;
	  }


	  // Aggregate root
	  // tag::get-aggregate-root[]
	  @GetMapping("/organizations")
	  List<Organization> all() {
		  List<Organization>  orgs =  repository.findAll();
		  System.out.println("orgs=="+orgs);
		  return orgs;
	  }
	  // end::get-aggregate-root[]

	  @PostMapping("/organizations")
	  Organization newEmployee(@RequestBody Organization newOrganization) {
		 System.out.println("new orga==="+newOrganization);
	    return repository.save(newOrganization);
	  }

	  // Single item
	  
//	  @GetMapping("/organizations/{id}")
//	  Employee one(@PathVariable Long id) {
//	    
//	    return repository.findById(id)
//	      .orElseThrow(() -> new EmployeeNotFoundException(id));
//	  }

}
