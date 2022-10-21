package com.ccsw.tutorial.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsw.tutorial.customer.model.Customer;
import com.ccsw.tutorial.customer.model.CustomerDto;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Customer get(Long id) {

        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Long id, CustomerDto dto) {

        Customer customer;

        if (id != null) {
            customer = customerRepository.findById(id).orElse(null);
        } else {
            customer = new Customer();

        }

        customer.setName(dto.getName());

        customerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {

        customerRepository.deleteById(id);
    }

}
