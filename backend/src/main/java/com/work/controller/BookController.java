package com.work.controller;

import com.work.model.Book;
import com.work.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @PostMapping
    public ResponseEntity<?> saveBook(@RequestBody Book book){

        return  new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);

    }

    @DeleteMapping("{bookId}")
    public ResponseEntity<?> deleteBook (@PathVariable Long bookId){

        bookService.deleteBook(bookId);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllBooks(){
        return new ResponseEntity<>(bookService.findAllBooks(), HttpStatus.OK);
    }
}
