package com.application.service;

import com.application.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

import com.application.domain.Customer;

@Service
public class CustomerService {

    @Autowired
    @Qualifier("customerRepository")
    CustomerRepository customerRepository;

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer findCustomerById(String cId) {
        return customerRepository.findBycId(cId);
    }

    public void deleteCustomer(String cId) {
        customerRepository.deleteById(cId);
    }

    public Collection<Customer> getAllCustomer() {

        return customerRepository.findAll();
    }
}
