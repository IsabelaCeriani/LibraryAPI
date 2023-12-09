package com.example.libraryapi.services;

import com.example.libraryapi.dtos.bookDTOs.CreateBookDTO;
import com.example.libraryapi.dtos.bookDTOs.GetBookDTO;
import com.example.libraryapi.model.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookService {

    GetBookDTO addBook(CreateBookDTO createBookDTO);
    List<GetBookDTO> getAllBooks();
    List<GetBookDTO> getBookByTitle(String title);
    GetBookDTO updateBook(CreateBookDTO createBookDTO, UUID bookId);
    GetBookDTO deleteBook(UUID bookId);

}
