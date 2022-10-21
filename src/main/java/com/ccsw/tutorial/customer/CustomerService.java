package com.ccsw.tutorial.customer;

import java.util.List;

import com.ccsw.tutorial.customer.model.Customer;
import com.ccsw.tutorial.customer.model.CustomerDto;

public interface CustomerService {

    List<Customer> findAll();

    Customer get(Long id);

    void save(Long id, CustomerDto dto);

    void delete(Long id);

}
