package com.blackcode.spring_boot_one_to_many.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;

    private String book_title;

    private Date book_publish;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Authors authors;

    public Books() {
    }

    public Books(Long book_id, String book_title, Date book_publish, Authors authors) {
        this.book_id = book_id;
        this.book_title = book_title;
        this.book_publish = book_publish;
        this.authors = authors;
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public Date getBook_publish() {
        return book_publish;
    }

    public void setBook_publish(Date book_publish) {
        this.book_publish = book_publish;
    }

    public Authors getAuthors() {
        return authors;
    }

    public void setAuthors(Authors authors) {
        this.authors = authors;
    }
}
