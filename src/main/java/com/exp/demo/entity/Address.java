package com.exp.demo.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Address {
	
	@Id @GeneratedValue
	long id;
	String name;
	String street;
	String state;
	String country;
	String zipcode;
	String nearby;
	String lat;
	String lng;
	
	@ManyToOne
	@JoinColumn(name = "entity_id")
	@JsonIgnore
	com.exp.demo.entity.Entity entity;
	
	public Address() {}
	
	public Address(String name, String street, String zipcode) {
		this.name = name;
		this.street = street;
		this.zipcode = zipcode;
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
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getNearby() {
		return nearby;
	}
	public void setNearby(String nearby) {
		this.nearby = nearby;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	
	public com.exp.demo.entity.Entity getEntity() {
		return entity;
	}

	public void setEntity(com.exp.demo.entity.Entity entity) {
		this.entity = entity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, street, zipcode);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return id == other.id && Objects.equals(name, other.name) && Objects.equals(street, other.street)
				&& Objects.equals(zipcode, other.zipcode);
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", name=" + name + ", street=" + street + ", state=" + state + ", country="
				+ country + ", zipcode=" + zipcode + ", nearby=" + nearby + ", lat=" + lat + ", lng=" + lng + "]";
	}
	
	
	

}
