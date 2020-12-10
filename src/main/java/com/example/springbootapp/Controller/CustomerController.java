package com.example.springbootapp.Controller;

import com.example.springbootapp.Entity.Customer;
import com.example.springbootapp.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class CustomerController {
    @Autowired
    private CustomerRepository customerrepository;
    @GetMapping("/customer")
    public List<Customer> getAllCustomer() {
        return this.customerrepository.findAll();
    }
}
