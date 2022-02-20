package com.exp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.exp.demo.entity.Organization;

@RepositoryRestResource(exported = true)
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
