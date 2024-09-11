package com.blackcode.spring_boot_one_to_many.controller;

import com.blackcode.spring_boot_one_to_many.model.Authors;
import com.blackcode.spring_boot_one_to_many.service.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/author")
public class AuthorsController {

    @Autowired
    private AuthorsService authorsService;

    @GetMapping
    public ResponseEntity<List<Authors>> getListAll(){
        return ResponseEntity.ok(authorsService.getListAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Authors> getAuthorById(@PathVariable Long id){
        Optional<Authors> authorData = authorsService.getAuthorById(id);
        return new ResponseEntity<>(authorData.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Authors> addAuthor(@RequestBody Authors author){
        Authors authorData = authorsService.addAuthor(author);
        return new ResponseEntity<>(authorData, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Authors> updateAuthor(@PathVariable Long id, @RequestBody Authors author){
        Authors authorData = authorsService.updateAuthor(id, author);
        return new ResponseEntity<>(authorData, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Long id){
        boolean authorData = authorsService.deleteAuthor(id);
        if(authorData){
            return new ResponseEntity<>("Data Success Delete", HttpStatus.OK);
        }
        return new ResponseEntity<>("Data Failed Delete", HttpStatus.NOT_FOUND);
    }

}
