package com.example.demo.repo;

import com.example.demo.model.Author;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface AuthorRepository extends JpaRepository<Author,Long > {
    @NotNull
    @Override
    <S extends Author> S save( S s);
}
