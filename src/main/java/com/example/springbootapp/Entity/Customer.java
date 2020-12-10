package com.example.springbootapp.Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "email")
    String email;
    @Column(name = "password")
    String pass;
    @Column(name = "book")
    String book;

    public Customer(String email, String pass, String book) {
        this.email = email;
        this.pass = pass;
        this.book = book;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }
}
