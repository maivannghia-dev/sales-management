package com.example.sales_management.controller;

import com.example.sales_management.entity.Customer;
import com.example.sales_management.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Customer> getById(@PathVariable Long id) {
        return customerService.getById(id);
    }

    @PostMapping
    public Customer create(@Valid @RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable Long id, @Valid @RequestBody Customer customer) {
        customer.setId(id);
        return customerService.save(customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        customerService.delete(id);
    }
}