package com.exp.demo.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;

import org.springframework.hateoas.RepresentationModel;

@javax.persistence.Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Entity extends RepresentationModel<Entity>{
	
	@Id @GeneratedValue
	private long id;
	
	private String name;
	
	public Entity() {}
	
	public Entity(String name) {
		super();
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity other = (Entity) obj;
		return id == other.id;
	}

	@ElementCollection
	@CollectionTable(joinColumns=@JoinColumn(name="entity_id"))
	@Column(name="telephone")
	private List<String> telephones = new ArrayList<String>();
	
	
	@ElementCollection
	@CollectionTable(joinColumns=@JoinColumn(name="entity_id"))
	@MapKeyColumn (name="TAG_ID")
	@Column(name="TAG_VALUE")
	private Map<String, String> tags = new HashMap<String, String>();
	
	@OneToMany(mappedBy = "entity", cascade = CascadeType.ALL)
	private List<Address> addresses = new ArrayList<Address>();

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

	public List<String> getTelephones() {
		return telephones;
	}

	public void setTelephones(List<String> telephones) {
		this.telephones = telephones;
	}
	
	public List<String> addTelephone(String telephone){
		this.telephones.add(telephone);
		return this.telephones;
	}

	public Map<String, String> getTags() {
		return tags;
	}

	public void setTags(Map<String, String> tags) {
		this.tags = tags;
	}
	
	public Map<String, String> addTag(String tagName,String tagValue){
		this.tags.put(tagName, tagValue);
		return this.tags;
	}

	public List<Address> getAddress() {
		return addresses;
	}


	public void setAddress(List<Address> address) {
		this.addresses = address;
	}
	
	public List<Address> addAddress(Address address) {
		address.setEntity(this);
		this.addresses.add(address);
		
		return this.addresses;
	}

	@Override
	public String toString() {
		return "Entity [id=" + id + ", name=" + name + "]";
	}
	
	
	

}
