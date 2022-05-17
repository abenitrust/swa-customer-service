package com.swa.application.controller;

import com.swa.application.domain.Customer;
import com.swa.application.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    CustomerService service;

    @PostMapping
    public ResponseEntity<String> add(@RequestBody Customer customer) {
        try {
            service.add(customer);
            return new ResponseEntity<>("Success!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer) {
        try {
            service.update(customer);
            return new ResponseEntity<>("Success!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<?> getCustomer(@PathVariable String customerId) {
        try {
            return new ResponseEntity<>(service.findById(customerId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<?> delete(@PathVariable String customerId) {
        try {
            service.delete(customerId);
            return new ResponseEntity<>("Success!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
