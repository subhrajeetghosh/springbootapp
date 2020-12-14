package com.example.springbootapp.Controller;

import com.example.springbootapp.Entity.Customer;
import com.example.springbootapp.Order.OrderRequest;
import com.example.springbootapp.Order.OrderResponse;
import com.example.springbootapp.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest request){
        return customerrepository.save(request.getCustomer());
    }
    @GetMapping("/findAllOrders")
    public List<Customer> findAllOrders(){
        return customerrepository.findAll();
    }
    @GetMapping("/getInfo")
    public List<OrderResponse> getJoinInformation(){
        return customerrepository.getJoinInformation();
    }
}
