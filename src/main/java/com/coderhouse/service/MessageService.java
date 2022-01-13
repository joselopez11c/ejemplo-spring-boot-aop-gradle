package com.coderhouse.service;

import com.coderhouse.handle.ApiRestException;

public interface MessageService {

    void update(Object customer) throws ApiRestException;
    void delete(Object customer);

}
