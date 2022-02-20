package com.exp.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemInWarehouse implements Serializable{
	
	@Id @GeneratedValue
	long id;

//	@EmbeddedId
//	@JsonIgnore
//	ItemWarehouseKey itemWarehouseKey;
	
	
	@ManyToOne
   // @MapsId("itemId")
    @JoinColumn(name = "item_id")
    Item item;

    @ManyToOne
    //@MapsId("warehouseId")
    @JoinColumn(name = "warehouse_id")
    @JsonIgnore
    Warehouse warehouse;

    int quantity;
    
    

	public ItemInWarehouse() {
		super();
	}

	public ItemInWarehouse(Item item, Warehouse warehouse, int quantity) {
		super();
		//this.itemWarehouseKey =  new ItemWarehouseKey(item.getId(), warehouse.getId());
		this.item = item;
		this.warehouse = warehouse;
		this.quantity = quantity;
	}
//
//	public ItemWarehouseKey getItemWarehouseKey() {
//		return itemWarehouseKey;
//	}
//
//	public void setItemWarehouseKey(ItemWarehouseKey itemWarehouseKey) {
//		this.itemWarehouseKey = itemWarehouseKey;
//	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
    
}
