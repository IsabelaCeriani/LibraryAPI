package com.example.libraryapi.services;

import com.example.libraryapi.dtos.bookDTOs.CreateBookDTO;
import com.example.libraryapi.dtos.bookDTOs.GetBookDTO;
import com.example.libraryapi.model.Book;
import com.example.libraryapi.repositories.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@Service
@Validated
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public GetBookDTO addBook(CreateBookDTO createBookDTO) {
        Book bookToBeAdded = createBookDTO.toBook();
        return bookRepository.save(bookToBeAdded).toGetBookDTO();
    }

    @Override
    public List<GetBookDTO> getAllBooks() {
        return bookRepository.findAll().stream().map(Book::toGetBookDTO).toList();
    }

    @Override
    public List<GetBookDTO> getBookByTitle(String name) {
        return bookRepository.findByTitleContains(name).stream().map(Book::toGetBookDTO).toList();
    }

    @Override
    public GetBookDTO updateBook(CreateBookDTO createBookDTO, UUID bookId) {
        Book bookToBeUpdated = bookRepository.findById(bookId).orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + bookId));
        bookToBeUpdated.setTitle(bookToBeUpdated.getTitle());
        bookToBeUpdated.setPrice(bookToBeUpdated.getPrice());
        return bookRepository.save(bookToBeUpdated).toGetBookDTO();
    }

    @Override
    public GetBookDTO deleteBook(UUID bookId) {
        Book bookToBeDeleted = bookRepository.findById(bookId).orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + bookId));
        bookRepository.delete(bookToBeDeleted);
        return bookToBeDeleted.toGetBookDTO();
    }
}
