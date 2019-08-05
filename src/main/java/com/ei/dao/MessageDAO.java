package com.ei.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ei.model.Message;

/***
 * @author acox
 * 
 *         This file accesses the database so that we are able to manage (create, read, update, delete) data in the
 *         message table.
 */
@Repository
public interface MessageDAO extends JpaRepository<Message, Integer> {
    
    @SuppressWarnings("unchecked")
    public Message save(Message message);

}
