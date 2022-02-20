package com.exp.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@PrimaryKeyJoinColumn(name = "warehouse_id")
public class Warehouse extends com.exp.demo.entity.Entity{
	
	private String category;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="org_id")
	@JsonIgnore
	private Organization organization;
	
	@OneToMany(mappedBy = "warehouse")
	Set<ItemInWarehouse> itemInWarehouse = new HashSet<ItemInWarehouse>();
	
	public Warehouse() {}

	public Warehouse(String name, String category, Address address) {
		super(name);
		this.category = category;
		addAddress(address);
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	

	public Set<ItemInWarehouse> getItemInWarehouse() {
		return itemInWarehouse;
	}

	public void setItemInWarehouse(Set<ItemInWarehouse> itemInWarehouse) {
		this.itemInWarehouse = itemInWarehouse;
	}
	
//	public Set<ItemInWarehouse> addItemInWarehouse(Item item,float quantity) {
//		ItemInWarehouse itmWarehouse = new ItemInWarehouse();
//		item.setItemInWarehouse(itemInWarehouse);
//	
//		itmWarehouse.setItem(item);
//		itmWarehouse.setWarehouse(this);
//		itmWarehouse.setQuantity(quantity);
//		
//		
//		itemInWarehouse.add(itmWarehouse);
//		return itemInWarehouse;
//		
//	}

}
