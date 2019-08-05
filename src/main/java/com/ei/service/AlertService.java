package com.ei.service;

import java.util.List;

import com.ei.form.AlertForm;
import com.ei.model.Alert;

public interface AlertService {

    /**
     * Returns the Alerts by active state
     * 
     * @param isActive
     *            - true is for all active alerts and false is for all inactive alerts
     * @return returns all active/inactive alert list if exists or empty list if none.
     */
    public List<Alert> getAllActiveAlerts(boolean isActive);

    /**
     * Saves the Alert from alert Form to Database
     * 
     * @param AlertForm
     *            - user filled form is the parameter to be saved
     * @return returns the newly added alert if all parameters are supplied correctly else gives errors.
     */
    public Alert saveAlert(AlertForm a);

    /**
     * Returns the Alert with given id
     * 
     * @param id
     *            - id of the alert to be found
     * @return returns the alert with id found in database or null if not found
     */
    public Alert findAlert(int id);

    /**
     * 
     * @param a
     *            - alert to be deleted
     * @return returns true if alert is successfully made inactive or false if not. Here deletion is happening by making
     *         them in active.
     */
    public boolean inActivateAlert(AlertForm a);
}
