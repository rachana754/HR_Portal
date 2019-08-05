package com.ei.service;

import com.ei.form.TellHRForm;
import com.ei.model.Message;

/***
 * 
 * @author acox 
 * This file works with/gives access to the DAO methods so that other files (Services and Controllers) have access to the configs in the DB.
 */
public interface MessageService {
    /**
     * taking in the tForm and saving it to the database table 'message'
     * @param tForm sending in the form thats being submitted
     * @return
     */
   public Message saveMessage(TellHRForm tForm);

}
