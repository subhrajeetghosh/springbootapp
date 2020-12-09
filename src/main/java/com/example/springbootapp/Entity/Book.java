
package com.example.springbootapp.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "postgres")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int Id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Author")
    private String author;

    public Book(int Id, String name, String author) {
        this.Id = Id;
        this.name = name;
        this.author = author;
    }

    public Book() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}