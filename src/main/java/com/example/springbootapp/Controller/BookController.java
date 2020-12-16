package com.example.springbootapp.Controller;

import com.example.springbootapp.Entity.Book;
import com.example.springbootapp.Exception.ResourceNotFoundException;
import com.example.springbootapp.Repository.BookRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EnableWebSecurity
@RestController
@RequestMapping("/api/v1")
public class BookController {
    @Autowired
    private BookRepository bookrepository;
    @GetMapping("/postgres")
    public List<Book> getAllBook() {
        return this.bookrepository.findAll();
    }
    //get books by id
    @GetMapping("/postgres/{Id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "Id") int Id)
            throws ResourceNotFoundException {
        Book book = bookrepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + Id));
        return ResponseEntity.ok().body(book);
    }
    /*@RequestMapping(value="/addBook", method = RequestMethod.POST)*/
    @PostMapping("/addBook")
    public Book createBook(@Valid @RequestBody Book book) {
        return this.bookrepository.save(book);
    }
    @PutMapping("/update/{id}")
    //@RequestMapping(value="/postgres/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Book> updateBook(@PathVariable(value = "Id") int Id,
                                           @NotNull @Validated @RequestBody Book bookDetails) throws ResourceNotFoundException {
        Book book = bookrepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + Id));

        book.setName(bookDetails.getName());
        book.setAuthor(bookDetails.getAuthor());
        final Book updatedBook = bookrepository.save(book);
        return ResponseEntity.ok(updatedBook);
    }
    @DeleteMapping("/postgres/{Id}")
    //@RequestMapping(value = "/postgres/{Id}", method = RequestMethod.DELETE)
    public Map<String, Boolean> deleteBook(@PathVariable(value = "Id") int Id)
            throws ResourceNotFoundException {
        Book book = bookrepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + Id));

        bookrepository.delete(book);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}