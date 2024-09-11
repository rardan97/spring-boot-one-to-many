package com.blackcode.spring_boot_one_to_many.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "authors")
public class Authors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long author_id;

    private String author_name;

    private String author_phoneNumber;

    private String author_address;

    @JsonIgnore
    @OneToMany(mappedBy = "authors")
    private Set<Books> books;

    public Authors() {
    }

    public Authors(Long author_id, String author_name, String author_phoneNumber, String author_address) {
        this.author_id = author_id;
        this.author_name = author_name;
        this.author_phoneNumber = author_phoneNumber;
        this.author_address = author_address;
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_phoneNumber() {
        return author_phoneNumber;
    }

    public void setAuthor_phoneNumber(String author_phoneNumber) {
        this.author_phoneNumber = author_phoneNumber;
    }

    public String getAuthor_address() {
        return author_address;
    }

    public void setAuthor_address(String author_address) {
        this.author_address = author_address;
    }

    public Set<Books> getBooks() {
        return books;
    }

    public void setBooks(Set<Books> books) {
        this.books = books;
    }
}
