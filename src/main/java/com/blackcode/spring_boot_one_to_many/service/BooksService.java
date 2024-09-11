package com.blackcode.spring_boot_one_to_many.service;

import com.blackcode.spring_boot_one_to_many.model.Books;

import java.util.List;
import java.util.Optional;

public interface BooksService {

    List<Books> getListAll();

    Optional<Books> getBookById(Long id);

    Books addBook(Books book);

    Books updateBook(Long id, Books book);

    boolean deleteBook(Long id);
}
