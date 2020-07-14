package com.example.demo;

import com.example.demo.model.Course;
import com.example.demo.model.Review;
import com.example.demo.repo.CourseRepository;
import com.example.demo.repo.ReviewRepository;
import com.example.demo.repo.StudentRepository;
import com.example.demo.service.ReviewService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class DemoApplication  implements CommandLineRunner{

    final ReviewRepository reviewRepository;
    final CourseRepository courseRepository;
    final StudentRepository studentRepository;
    final ReviewService reviewService;

    public DemoApplication(ReviewRepository reviewRepository, CourseRepository courseRepository, StudentRepository studentRepository, ReviewService reviewService) {
        this.reviewRepository = reviewRepository;
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.reviewService = reviewService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }

    @Override
    @Transactional
    public  void  run(String... arg) throws Exception{
//        Review review = new Review(2L, 2, "not good");
//        reviewService.create(1002L, review);

//        Student student = studentRepository.getOne(20171L);
//        Course course = courseRepository.getOne(1002L);
//
//        student.addCourse(course);
////        course.addStudent(student);
//        studentRepository.save(student);


//        Review review = new Review(7, 3, "not good but average i see all ");
//        Course course = courseRepository.findById(1002L).get();
//        course.addReview(review);
//        review.setCourse(course);
//        courseRepository.save(course);
//        reviewRepository.save(review);


        /**
         * interesting behavior set review
         */
//
//        Review review = new Review(5, 3, "not good but average");
//        Course course = courseRepository.findById(102L).get();
//        course.addReview(review);
//        review.setCourse(course);
//        courseRepository.save(course);
//        reviewRepository.save(review);


        /**

         in this blew of code try  course and review save same time  one transactional
         stupid comment
         **/

//        reviewRepository.deleteAll();
//        courseRepository.deleteAll();
//        Review review = new Review(1, 5, "nice course");
//        Course course = new Course(102L, "Advance java", null);
//        courseRepository.save(course);
//        course.addReview(review);
//        review.setCourse(course);
//        reviewRepository.save(review);
    }


}
