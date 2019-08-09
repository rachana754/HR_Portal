package com.ei.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ei.dao.AlertDAO;
import com.ei.form.AlertForm;
import com.ei.model.Alert;

@Service
@Transactional
public class AlertServiceImpl implements AlertService {

    @Autowired
    private AlertDAO alertDAO;

    public List<Alert> getAllActiveAlerts(boolean isActive) {
        return alertDAO.findByIsActive(isActive);
    }

    public Alert saveAlert(AlertForm a) {
        Alert alert = new Alert();
        Date date = new Date();

        if (a.getId() != null) {
            // save updated alert
            alert = this.findAlert(a.getId());
            alert.setLastModifiedDate(date);
        } else {
            // save new alert
            alert.setCreateDate(date);
            alert.setActive(true);
        }

        alert.setSubject(a.getSubject());
        alert.setDescription(a.getDescription());

        return alertDAO.save(alert);
    }

    public Alert findAlert(int id) {
        return alertDAO.findById(id);
    }

    public boolean inActivateAlert(AlertForm a) {
        Alert alert = this.findAlert(a.getId());
        if (alert != null) {
            alert.setActive(false);
            Date date = new Date();
            alert.setDeleteDate(date);
            alertDAO.save(alert);
            return true;
        }
        return false;
    }

}
