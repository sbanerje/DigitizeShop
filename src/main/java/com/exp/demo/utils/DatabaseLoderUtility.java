package com.exp.demo.utils;


import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.exp.demo.entity.Address;
import com.exp.demo.entity.Customer;
import com.exp.demo.entity.Item;
import com.exp.demo.entity.ItemInWarehouse;
import com.exp.demo.entity.LineItem;
import com.exp.demo.entity.Organization;
import com.exp.demo.entity.SalesOrder;
import com.exp.demo.entity.Unit;
import com.exp.demo.entity.Unit.UnitCategory;
import com.exp.demo.entity.Warehouse;
import com.exp.demo.repository.CustomerRepository;
import com.exp.demo.repository.ItemInWarehouseRepository;
import com.exp.demo.repository.ItemRepository;
import com.exp.demo.repository.OrganizationRepository;
import com.exp.demo.repository.SalesOrderRepository;
import com.exp.demo.repository.UnitRepositoory;
import com.exp.demo.repository.WarehouseRepository;

@Configuration
public class DatabaseLoderUtility {
	
	  private static final Logger log = LoggerFactory.getLogger(DatabaseLoderUtility.class);

	  @Autowired
	  ItemInWarehouseRepository itwrep;
	 
	  @Autowired
	  ItemRepository itemRepo;
	  
	  @Autowired
	  WarehouseRepository warehouseRepo;
	  
	  @Autowired
	  UnitRepositoory unitRepo;
	 
	  @Autowired
	  SalesOrderRepository salesOrderRepo;
	  
	  @Autowired
	  CustomerRepository custRepo;
	  
	  
	  @Bean
	  CommandLineRunner initDatabase(OrganizationRepository repository) {

		//Set<Warehouse> w1 = new HashSet<Warehouse>(Arrays.asList(new Warehouse[]{new Warehouse("A", "1"),new Warehouse("B", "2")}));
	    Address adr1 = new Address("1/92", "Bangalore", "560093");
	    Address adr12 = new Address("3/92", "Gandhi Colony", "560093");
	    Address adr13 = new Address("4/92", "Gandhi Colony", "560093");
	    
	    Address adr2 = new Address("B301", "Kaggadaspura", "560093");
	    
		Organization org1 = new Organization("Test Organizaton", adr1);
		Warehouse warehouse1 = new Warehouse("A", "1", adr12);
		Customer customer = new Customer("Big Customer");
		customer.addAddress(adr2);
		customer.addTelephone("7259880256");
		customer.setPriorityCustomer(true);
	
		Unit unit1 = new Unit("ltr", "Liter", UnitCategory.Volume, Arrays.asList(1.0f, 4.0f, 10.0f, 20.0f));
		Unit unit2 = new Unit("kgs", "Kg", UnitCategory.Weight, 1.0f);

		Item item = new Item("Mustard Oil", "12345", 100f, 120f, unit1,  unit1.getAvailableSizes().get(1));
		
		Item item2 = new Item("Rice", "567",1000f, 2000f, unit2,  unit1.getAvailableSizes().get(0));
		//warehouse1.addItemInWarehouse(item, 10);
		
		LineItem lineItem1 = new LineItem(item, 5, 0);
		LineItem lineItem2 = new LineItem(item2, 2, 0);
		
		SalesOrder salesOrder = new SalesOrder();
		salesOrder.addLineItems(lineItem1);
		salesOrder.addLineItems(lineItem2);
		salesOrder.setCustomer(customer);
		
		org1.addWarehouse(warehouse1);
		
		org1.addWarehouse(new Warehouse("B", "2", adr13));
		
		org1.addTag("main", "yes");
		org1.addTag("estd", "2022");
		
		org1.addTelephone("898987689");
		
		
		return args -> {
			
			log.info("Preloading org " + custRepo.save(customer)); 
			
	      log.info("Preloading org " + repository.save(org1));
	      
	      log.info("Preloading warehouse" + warehouseRepo.save(warehouse1));
	      
	      log.info("Preloading unit" + unitRepo.saveAll(Arrays.asList(unit1, unit2)));

	      log.info("Preloading item" + itemRepo.saveAll(Arrays.asList(item, item2)));
	      
	      ItemInWarehouse itw = new ItemInWarehouse(item, warehouse1, 10);
	      ItemInWarehouse itw2 = new ItemInWarehouse(item2, warehouse1, 5);
		
			//item.getItemInWarehouse().add(itw);
			//warehouse1.getItemInWarehouse().add(itw);
			
	     log.info("Preloading " + itwrep.saveAll(Arrays.asList(itw, itw2)));
	     log.info("adr2===="+adr2.getId()+"    entity==="+adr2.getEntity());
	     
	     //new Address("1ST Cross", "Kaggadaspura", "560093")
	      log.info("Preloading " + repository.save(new Organization("Vegetable Mart", new Address("1ST Cross", "Kaggadaspura", "560093"))));
	      
	      log.info("Preloading " + salesOrderRepo.save(salesOrder));
	    };
	    
	    
	  }
	  
	  
	  
	
}
