package com.example.springbootapp.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "Customer")
public class Customer {
    @Id
    @Column(name = "user_id")
    int id;
    @Column(name = "user_email")
    String email;
    @Column(name = "user_password")
    String pass;
    @OneToMany(targetEntity = Book.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="cp_fk",referencedColumnName = "user_id")
    List<Book> book = new ArrayList<>();
}
