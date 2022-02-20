package com.exp.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class SalesOrder {
	
	@Id @GeneratedValue
	long id;
	
	Date date;
	
//	PurchaseOrder purchaseOrder;
	
	@ManyToOne
	@JoinColumn(name = "customer_id" , nullable=false)
	Customer customer;
	
	@OneToMany(mappedBy = "salesOrder", cascade = CascadeType.ALL)
	List<LineItem> lineItems = new ArrayList<>();
	
	float discount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
	
	public List<LineItem> addLineItems(LineItem lineItem) {
		lineItem.setSalesOrder(this);
		lineItems.add(lineItem);
	
		return lineItems;
	}


	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	
	
}