package com.blackcode.spring_boot_one_to_many.repository;

import com.blackcode.spring_boot_one_to_many.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {
}
