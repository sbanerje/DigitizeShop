package com.exp.demo.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "customer_id")
public class Customer extends com.exp.demo.entity.Entity{
	
	
	boolean priorityCustomer;
	
	public Customer() {};
	
	public Customer(String name) {
		super(name);
	}

	public boolean isPriorityCustomer() {
		return priorityCustomer;
	}

	public void setPriorityCustomer(boolean priorityCustomer) {
		this.priorityCustomer = priorityCustomer;
	}
	
	

}
