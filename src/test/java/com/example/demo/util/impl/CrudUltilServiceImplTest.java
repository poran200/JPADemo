package com.example.demo.util.impl;

import com.example.demo.model.Author;
import com.example.demo.repo.AuthorRepository;
import com.example.demo.repo.BookRepository;
import com.example.demo.util.CrudUntilService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CrudUltilServiceImplTest {

    @Autowired
    CrudUntilService crudUltilService;
    @Autowired
    AuthorRepository repository;
    @Autowired
    BookRepository bookRepository;

    @Test
    void save() {
        var author = new Author("Mijan", "M@gmail.com", 24);
        Author save = (Author) crudUltilService.save(author, repository);
        assertEquals(24,save.getAge());

    }
    @Test
    void findById(){
        var object = (Author)crudUltilService.findById(1, repository, Author.class);
        assertEquals(1,object.getId());
    }
}