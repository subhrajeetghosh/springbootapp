
package com.example.springbootapp.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "Book")
public class Book {

    @Id
    @Column(name="book_id")
    private  int Id;

    @Column(name = "book_name")
    private String name;

    @Column(name = "book_author")
    private String author;
}