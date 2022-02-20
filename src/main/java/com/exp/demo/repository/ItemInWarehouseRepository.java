package com.exp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemInWarehouseRepository
		extends JpaRepository<com.exp.demo.entity.ItemInWarehouse, Long> {

}
