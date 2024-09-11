package com.blackcode.spring_boot_one_to_many.repository;

import com.blackcode.spring_boot_one_to_many.model.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends JpaRepository<Authors, Long> {
}
