package com.example.springbootapp.Controller;

import com.example.springbootapp.Entity.Book;
import com.example.springbootapp.Exception.ResourceNotFoundException;
import com.example.springbootapp.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1")
public class BookController {
    @Autowired
    private BookRepository bookrepository;
    //get all books
    @GetMapping("/postgres")
    public List<Book> getAllBook() {
        return this.bookrepository.findAll();
    }
    //get books by id
    @GetMapping("/postgres/{Id}")
    public ResponseEntity<Book> getEmployeeById(@PathVariable(value = "Id") int Id)
            throws ResourceNotFoundException {
        Book book = bookrepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + Id));
        return ResponseEntity.ok().body(book);
    }

    @PostMapping("/postgres")
    public Book createBook(@Validated @RequestBody Book book) {
        return this.bookrepository.save(book);
    }
    @PutMapping("/postgres/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable(value = "Id") int Id,
                                                   @Validated @RequestBody Book bookDetails) throws ResourceNotFoundException {
        Book book = bookrepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + Id));

        book.setName(bookDetails.getName());
        book.setAuthor(bookDetails.getAuthor());
        final Book updatedBook = bookrepository.save(book);
        return ResponseEntity.ok(updatedBook);
    }
    //hbyuhbuinbi
    @DeleteMapping("/postgres/{Id}")
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
