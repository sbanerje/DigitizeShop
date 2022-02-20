package com.exp.demo.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exp.demo.entity.SalesOrder;
import com.exp.demo.repository.SalesOrderRepository;

@RestController
public class SalesOrderController {

	
	private final SalesOrderRepository repository;

	SalesOrderController(SalesOrderRepository repository) {
	    this.repository = repository;
	  }


	  // Aggregate root
	  // tag::get-aggregate-root[]
	  @GetMapping("/salesorders")
	  List<SalesOrder> all() {
		  List<SalesOrder>  salesOrders =  repository.findAll();
		  //System.out.println("orgs=="+orgs);
		  return salesOrders;
	  }
}
