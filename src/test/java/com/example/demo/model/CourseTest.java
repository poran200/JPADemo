package com.example.demo.model;

import com.example.demo.repo.CourseRepository;
import com.example.demo.repo.ReviewRepository;
import com.example.demo.service.ReviewService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest
class CourseTest {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    ReviewService reviewService;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    void createCourse() {
        Course course = new Course(1002, "Data structure", null,null);
        Course saveCourse = courseRepository.save(course);
         logger.info("save course {}",saveCourse);
         assertEquals(saveCourse.getId(),course.getId());
         assertEquals(saveCourse.getTitle(),course.getTitle());
    }

    /**
     *
     *
     */
    @Test

    void addReviewTest() {
        Review review = new Review(2L, 2, "not good");
        Review reviewSaved = reviewService.create(1002L, review);
        logger.info("saved review {}", reviewSaved);
        assertNotNull(reviewSaved," review not null");

    }

    @Test
    void deleteTest() {
        reviewService.deleteReview(2L);
    }

}