package com.ei.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ei.model.Alert;

@Repository
@Transactional
public interface AlertDAO extends JpaRepository<Alert, Integer> {

    /**
     * Returns the Alerts by active state
     * 
     * @param isActive
     *            - true is for all active alerts and false is for all inactive alerts
     * @return returns all active/inactive alert list if exists or empty list if none.
     */
    List<Alert> findByIsActive(boolean isActive);

    /**
     * Saves the Alert from alert Form to Database
     * 
     * @param AlertForm
     *            - user filled form is the parameter to be saved
     * @return returns the newly added alert if all parameters are supplied correctly else gives errors.
     */
    @SuppressWarnings("unchecked")
    Alert save(Alert a);

    /**
     * Returns the Alert with given id
     * 
     * @param id
     *            - id of the alert to be found
     * @return returns the alert with id found in database or null if not found.
     */
    Alert findById(int id);

}
