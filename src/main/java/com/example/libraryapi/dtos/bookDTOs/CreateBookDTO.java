package com.example.libraryapi.dtos.bookDTOs;

import com.example.libraryapi.model.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class CreateBookDTO {

    private String title;
    private String author;
    private double price;
    private LocalDateTime createdAt;

    public CreateBookDTO(String title, String author, double price) {
        this.title = title.toLowerCase();
        this.author = author.toLowerCase();
        this.price = price;
        this.createdAt = LocalDateTime.now();
    }

    public Book toBook() {
        return Book.builder()
                .title(this.title)
                .author(this.author)
                .price(this.price)
                .createdAt(this.createdAt)
                .build();
    }
}

