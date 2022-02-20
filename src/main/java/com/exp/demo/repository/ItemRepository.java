package com.exp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp.demo.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
