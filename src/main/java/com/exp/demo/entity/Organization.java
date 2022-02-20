package com.exp.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "org_id")
public class Organization extends com.exp.demo.entity.Entity{
	
	public Organization() {}
	
	
	public Organization(String name, Address address) {
		super(name);
		addAddress(address);
	}
	
	
	
	private String gstNo;
	
	@OneToMany(mappedBy = "organization", fetch = FetchType.LAZY)
	private Set<Warehouse> warehouses = new HashSet<Warehouse>();
	

	
	
	public Set<Warehouse> getWarehouses() {
		return warehouses;
	}


	public void setWarehouses(Set<Warehouse> warehouses) {
		for(Warehouse w : warehouses) {
			w.setOrganization(this);
		}
		this.warehouses = warehouses;
	}
	
	public void addWarehouse(Warehouse warehouse) {
		warehouse.setOrganization(this);
		warehouses.add(warehouse);
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
}
