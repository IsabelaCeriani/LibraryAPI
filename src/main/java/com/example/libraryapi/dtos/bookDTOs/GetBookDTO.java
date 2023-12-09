package com.example.libraryapi.dtos.bookDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class GetBookDTO {

    private String title;
    private String author;
    private double price;

    private LocalDateTime createdAt;

}
