package com.example.libraryapi.model;

import com.example.libraryapi.dtos.bookDTOs.GetBookDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    private String title;
    private String author;
    private double price;

    private LocalDateTime createdAt;

    public GetBookDTO toGetBookDTO() {
        return new GetBookDTO(this.title, this.author, this.price, this.createdAt);
    }
}