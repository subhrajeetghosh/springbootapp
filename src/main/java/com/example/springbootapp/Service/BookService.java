package com.example.springbootapp.Service;

import com.example.springbootapp.Entity.Book;
import com.example.springbootapp.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookService {
    @Autowired
    private BookRepository repository;

    public Book saveProduct(Book product) {
        return repository.save(product);
    }

    public List<Book> saveProducts(List<Book> products) {
        return repository.saveAll(products);
    }

    public List<Book> getProducts() {
        return repository.findAll();
    }

    public Book getProductById(int id) {
        return repository.findById(id).orElse(null);
    }


    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    public Book updateProduct(Book product) {
        Book existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setAuthor(product.getAuthor());
        return repository.save(existingProduct);
    }
}
