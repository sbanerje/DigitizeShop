package com.exp.demo.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Item {

	@Id @GeneratedValue
	long id;
	
	String name;
	
	String HSNCode;
	
	double costPrice;
	
	double sellingPrice;
	
	
	@OneToOne
	@JoinColumn(name = "unit_id")
	Unit unit;
	
	float size;
	
	public Item() {
		super();
	}

	public Item(String name, String hSNCode, double costPrice, double sellingPrice, Unit unit, float size) {
		super();
		this.name = name;
		this.HSNCode = hSNCode;
		this.costPrice =costPrice;
		this.sellingPrice = sellingPrice;
		this.unit = unit;
		this.size = size;
		
	}

	@OneToMany(mappedBy = "item")
	@JsonIgnore
	Set<ItemInWarehouse> itemInWarehouse =  new HashSet<ItemInWarehouse>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHSNCode() {
		return HSNCode;
	}

	public void setHSNCode(String hSNCode) {
		HSNCode = hSNCode;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public Set<ItemInWarehouse> getItemInWarehouse() {
		return itemInWarehouse;
	}

	public void setItemInWarehouse(Set<ItemInWarehouse> itemInWarehouse) {
		this.itemInWarehouse = itemInWarehouse;
	}
	
//	public Set<ItemInWarehouse> addItemInWarehouse(Warehouse warehouse,float quantity) {
//		ItemInWarehouse itmWarehouse = new ItemInWarehouse();
//		itmWarehouse.setItem(this);
//		itmWarehouse.setWarehouse(warehouse);
//		itmWarehouse.setQuantity(quantity);
//		
//		
//		itemInWarehouse.add(itmWarehouse);
//		return itemInWarehouse;
//		
//	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", HSNCode=" + HSNCode + ", unit=" + unit + "]";
	}
	
	
	
}
