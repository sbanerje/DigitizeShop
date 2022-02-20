package com.exp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp.demo.entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

}
