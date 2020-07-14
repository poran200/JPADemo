package com.example.demo;

import com.example.demo.model.Passport;
import com.example.demo.model.Student;
import com.example.demo.repo.PassportRepository;
import com.example.demo.repo.StudentRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DemoApplicationTests {
 Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);

     @Autowired
     StudentRepository  studentRepository;

     @Autowired
     PassportRepository passportRepository;


    @BeforeAll
    static void beforeAll() {
        System.out.println("Test start");
    }

    @AfterAll
    static void afterAll() {

    }

    @Test
    @Transactional
    void deleteAll() {
        studentRepository.deleteAll();
        passportRepository.deleteAll();
    }

    @Test
    void createStudent() {
       Passport passport = new Passport(201, "WE34556");
       passportRepository.save(passport);
       Student student = new Student(101, "jone");
       studentRepository.save(student);
    }
   @Test
   void updateStudent() {
      Passport passport = passportRepository.getOne( 201L);
//      passportRepository.save(passport);
      Student student = new Student(101, "jone");
      student.setPassport(passport);
      studentRepository.save(student);

   }

   @Test
//   @Transactional
   void findStudent() {
       Optional<Student> optionalStudent = studentRepository.findById(101L);
       logger.info("student {}",optionalStudent);
       assertNotNull(optionalStudent);
   }

    @Test
//    @Transactional
    void findPassport() {
        Optional<Passport> optionalPassport = passportRepository.findById(201L);
        logger.info("passPort {}", optionalPassport);
        logger.info("student {}", optionalPassport.get().getStudent());
        assertNotNull(optionalPassport);
    }

//    @Test
//    void deleteById() {
//        studentRepository.deleteById(101L);
//        passportRepository.deleteById(201L);
//
//    }
}
