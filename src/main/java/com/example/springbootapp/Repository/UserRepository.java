package com.example.springbootapp.Repository;

import com.example.springbootapp.Entity.UserDao;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserDao, Integer> {
    UserDao findByUsername(String username);
}