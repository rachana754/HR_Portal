package com.ei.service;


 
import java.util.Date;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ei.dao.MessageDAO;
import com.ei.form.TellHRForm;
import com.ei.model.Message;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {
    
    @Autowired
    MessageDAO messageDAO;

    
    public Message saveMessage(TellHRForm m) {
        Message message = new Message();
        message.setSubject(m.getSubject());
        message.setMessage(m.getMessage());
        message.setDateSent(new Date());
        return messageDAO.save(message);
    }


}
