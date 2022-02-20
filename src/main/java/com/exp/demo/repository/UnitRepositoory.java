package com.exp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp.demo.entity.Unit;

public interface UnitRepositoory extends JpaRepository<Unit, Long> {

}
