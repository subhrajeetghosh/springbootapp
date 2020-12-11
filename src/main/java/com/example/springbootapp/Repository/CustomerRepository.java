package com.example.springbootapp.Repository;

import com.example.springbootapp.Entity.Customer;
import com.example.springbootapp.Order.OrderResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("SELECT new com.example.springbootapp.Controller.OrderResponse(c.name, b.name) FROM CUSTOMER c JOIN c.book b")
    public List<OrderResponse> getJoinInformation();
}
