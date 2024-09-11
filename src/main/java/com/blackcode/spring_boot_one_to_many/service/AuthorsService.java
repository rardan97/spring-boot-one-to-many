package com.blackcode.spring_boot_one_to_many.service;

import com.blackcode.spring_boot_one_to_many.model.Authors;

import java.util.List;
import java.util.Optional;

public interface AuthorsService {

    List<Authors> getListAll();

    Optional<Authors> getAuthorById(Long id);

    Authors addAuthor(Authors authors);

    Authors updateAuthor(Long id, Authors user);

    boolean deleteAuthor(Long id);

}
