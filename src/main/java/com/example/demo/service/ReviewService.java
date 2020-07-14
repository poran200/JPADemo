package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.model.Review;
import com.example.demo.repo.CourseRepository;
import com.example.demo.repo.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    CourseRepository  courseRepository;


    public Review create(long courseId, Review review){
        Course course = courseRepository.findById(courseId).get();
         course.addReview(review);
        return reviewRepository.save(review);

    }

    public  void  deleteReview(long Id){
        reviewRepository.deleteById(Id);
    }


}
