package com.coderhouse.service;

import com.coderhouse.handle.ApiRestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    Object ejemplodeBaseDatosSQLSErver;
    @Autowired
    Object ejemplodeBaseDatosMongoDB;
    @Autowired
    Object ejemplodeApiRest;

    @Override
    public void update(Object customer) throws ApiRestException {
        if(customer.equals(null)) {
            throw new ApiRestException("prueba");
        }
    }

    @Override
    public void delete(Object customer) {

    }
}
