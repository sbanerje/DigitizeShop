package com.exp.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Unit {
	
	@Id @GeneratedValue
	long id;
	
	String name;
	
	String displayName;
	
	public enum UnitCategory{
		Weight, Volume, Length, Currency, Speed, BAG
	}
	
	@Enumerated(EnumType.STRING)
	UnitCategory catecory;

	@ElementCollection
	@CollectionTable(joinColumns=@JoinColumn(name="unit_id"))
	@Column(name="available_size")
	@JsonIgnore
	List<Float> availableSizes = new ArrayList<>();
	
	public Unit() {
		super();
	}

	public Unit(String name, String displayName, UnitCategory catecory, float size) {
		super();
		this.name = name;
		this.displayName = displayName;
		this.catecory = catecory;
		this.availableSizes.add(size);
	}
	
	public Unit(String name, String displayName, UnitCategory catecory, List<Float> sizes) {
		super();
		this.name = name;
		this.displayName = displayName;
		this.catecory = catecory;
		this.availableSizes.addAll(sizes);
	}

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

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public UnitCategory getCatecory() {
		return catecory;
	}

	public void setCatecory(UnitCategory catecory) {
		this.catecory = catecory;
	}
	
	public List<Float> getAvailableSizes() {
		return availableSizes;
	}

	public void setAvailableSizes(List<Float> availableSizes) {
		this.availableSizes = availableSizes;
	}
	
	public List<Float> addAvailableSizes(float newSize) {
		 this.availableSizes.add(newSize);
		 return this.availableSizes;
	}
	

	@Override
	public String toString() {
		return "Unit [name=" + name + ", displayName=" + displayName + ", catecory=" + catecory + "]";
	}
	
	

}
