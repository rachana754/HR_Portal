package com.ei.service;

import com.ei.model.ConfigSpecification;

/***
 * 
 * @author acox
 * This file works with/gives access to the DAO methods so that other files (Services and Controllers) have access to the configs in the DB.
 */
public interface ConfigService {
    public ConfigSpecification findByName(String name);
}
