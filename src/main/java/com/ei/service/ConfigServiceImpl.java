package com.ei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ei.dao.ConfigSpecificationDAO;
import com.ei.model.ConfigSpecification;

@Service
public class ConfigServiceImpl implements ConfigService {
    
    @Autowired
    private ConfigSpecificationDAO configSpecificationDAO;

    @Override
    public ConfigSpecification findByName(String name) {
        return configSpecificationDAO.findByName(name);
    }

}
