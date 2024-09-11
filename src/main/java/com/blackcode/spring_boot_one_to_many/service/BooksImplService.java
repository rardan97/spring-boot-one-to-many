package com.blackcode.spring_boot_one_to_many.service;

import com.blackcode.spring_boot_one_to_many.model.Authors;
import com.blackcode.spring_boot_one_to_many.model.Books;
import com.blackcode.spring_boot_one_to_many.repository.AuthorsRepository;
import com.blackcode.spring_boot_one_to_many.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksImplService implements BooksService {

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private AuthorsRepository authorsRepository;

    @Override
    public List<Books> getListAll() {
        return booksRepository.findAll();
    }

    @Override
    public Optional<Books> getBookById(Long id) {
        return booksRepository.findById(id);
    }

    @Override
    public Books addBook(Books book) {
        Books bookTemp = new Books();
        bookTemp.setBook_title(book.getBook_title());
        bookTemp.setBook_publish(book.getBook_publish());
        bookTemp.setAuthors(book.getAuthors());
        Books booksRes = booksRepository.save(bookTemp);
        Optional<Authors> authors = authorsRepository.findById(booksRes.getAuthors().getAuthor_id());
        booksRes.setAuthors(authors.get());
        return booksRes;
    }

    @Override
    public Books updateBook(Long id, Books book) {
        Optional<Books> bookData = booksRepository.findById(id);
        if(bookData.isPresent()){
            bookData.get().setBook_title(book.getBook_title());
            bookData.get().setBook_publish(book.getBook_publish());
            bookData.get().setAuthors(book.getAuthors());
            Books booksRes = booksRepository.save(bookData.get());
            Optional<Authors> authors = authorsRepository.findById(booksRes.getAuthors().getAuthor_id());
            booksRes.setAuthors(authors.get());
            return booksRes;
        }
        return null;
    }

    @Override
    public boolean deleteBook(Long id) {
        Optional<Books> bookData = booksRepository.findById(id);
        if(bookData.isPresent()){
            booksRepository.deleteById(id);
            return true;
        }
        return false;

    }
}
