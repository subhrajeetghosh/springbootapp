
package com.example.springbootapp.Entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@ToString
@Table(name = "postgres")
public class Book {

    @Id
    @Column(name="book_id")
    private  int Id;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

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