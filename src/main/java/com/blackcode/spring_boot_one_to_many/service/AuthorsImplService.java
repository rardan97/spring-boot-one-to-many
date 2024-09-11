package com.blackcode.spring_boot_one_to_many.service;

import com.blackcode.spring_boot_one_to_many.model.Authors;
import com.blackcode.spring_boot_one_to_many.repository.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorsImplService implements AuthorsService {

    @Autowired
    private AuthorsRepository authorsRepository;

    @Override
    public List<Authors> getListAll() {
        return authorsRepository.findAll();
    }

    @Override
    public Optional<Authors> getAuthorById(Long id) {
        return authorsRepository.findById(id);
    }

    @Override
    public Authors addAuthor(Authors author) {
        Authors authorTemp = new Authors();
        authorTemp.setAuthor_name(author.getAuthor_name());
        authorTemp.setAuthor_phoneNumber(author.getAuthor_phoneNumber());
        authorTemp.setAuthor_address(author.getAuthor_address());
        return authorsRepository.save(authorTemp);
    }

    @Override
    public Authors updateAuthor(Long id, Authors author) {
        Optional<Authors> authorData = authorsRepository.findById(id);
        if(authorData.isPresent()){
            authorData.get().setAuthor_name(author.getAuthor_name());
            authorData.get().setAuthor_phoneNumber(author.getAuthor_phoneNumber());
            authorData.get().setAuthor_address(author.getAuthor_address());
            return authorsRepository.save(authorData.get());
        }
        return null;
    }

    @Override
    public boolean deleteAuthor(Long id) {
        Optional<Authors> authorData = authorsRepository.findById(id);
        if(authorData.isPresent()){
            authorsRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
