package com.example.springbootapp.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "id")
    int id;
    @Column(name = "email")
    String email;
    @Column(name = "password")
    String pass;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn( name = "pc_fid", referencedColumnName = "id")
    List<Book> book = new ArrayList<>();

    public Customer(String email, String pass, List<Book> book) {
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

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }
}
