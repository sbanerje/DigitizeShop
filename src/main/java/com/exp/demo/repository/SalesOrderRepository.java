package com.exp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp.demo.entity.SalesOrder;

public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long> {

}
