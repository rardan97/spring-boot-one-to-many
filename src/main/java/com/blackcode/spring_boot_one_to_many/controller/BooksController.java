package com.blackcode.spring_boot_one_to_many.controller;

import com.blackcode.spring_boot_one_to_many.model.Books;
import com.blackcode.spring_boot_one_to_many.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book")
public class BooksController {

    @Autowired
    private BooksService booksService;

    @GetMapping
    public ResponseEntity<List<Books>> getListData(){
        return ResponseEntity.ok(booksService.getListAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Books> getBookById(@PathVariable Long id){
        Optional<Books> bookData = booksService.getBookById(id);
        return new ResponseEntity<>(bookData.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Books> addBook(@RequestBody Books book){
        Books bookData = booksService.addBook(book);
        return new ResponseEntity<>(bookData, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Books> updateBook(@PathVariable Long id, @RequestBody Books book){
        Books bookData = booksService.updateBook(id, book);
        return new ResponseEntity<>(bookData, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
        boolean bookData = booksService.deleteBook(id);
        if(bookData){
            return new ResponseEntity<>("Data Success Delete", HttpStatus.OK);
        }
        return new ResponseEntity<>("Data Failed Delete", HttpStatus.NOT_FOUND);
    }
}
