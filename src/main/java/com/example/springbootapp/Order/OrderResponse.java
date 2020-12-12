package com.example.springbootapp.Order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class OrderResponse {

    private String email;
    private String bookname;

    public OrderResponse(String name, String bookcase) {
        this.email = name;
        this.bookname = bookcase;
    }
}
