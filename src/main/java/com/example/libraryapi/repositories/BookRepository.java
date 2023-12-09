package com.example.libraryapi.repositories;

import com.example.libraryapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {

    List<Book> findByTitleContains(String title);


    List<Book> findByAuthor(String author);



}
