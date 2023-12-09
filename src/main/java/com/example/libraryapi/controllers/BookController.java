package com.example.libraryapi.controllers;

import com.example.libraryapi.dtos.bookDTOs.CreateBookDTO;
import com.example.libraryapi.dtos.bookDTOs.GetBookDTO;
import com.example.libraryapi.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/addBook")
    public ResponseEntity<GetBookDTO> addBook(@RequestBody CreateBookDTO createBookDTO){
        return ResponseEntity.ok(bookService.addBook(createBookDTO));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<GetBookDTO>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/getByName")
    public ResponseEntity<List<GetBookDTO>> getBookByTitle(@RequestParam(value = "title", required = false) String title){
        return ResponseEntity.ok(bookService.getBookByTitle(title.toLowerCase()));
    }

    @PatchMapping("/updateBook/{bookId}")
    public ResponseEntity<GetBookDTO> updateBook(@RequestBody CreateBookDTO createBookDTO, @PathVariable UUID bookId){
        return ResponseEntity.ok(bookService.updateBook(createBookDTO, bookId));
    }

    @DeleteMapping("/deleteBook/{bookId}")
    public ResponseEntity<GetBookDTO> deleteBook(@PathVariable UUID bookId){
        return ResponseEntity.ok(bookService.deleteBook(bookId));
    }
}
