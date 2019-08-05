package com.ei.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ei.model.ConfigSpecification;

/***
 * @author acox
 * 
 *         This file accesses the database so that we are able to manage (create, read, update, delete) data in the
 *         config specification table.
 */
@Repository
public interface ConfigSpecificationDAO extends JpaRepository<ConfigSpecification, Integer> {
    
    public ConfigSpecification findByName(String name);
    
}
