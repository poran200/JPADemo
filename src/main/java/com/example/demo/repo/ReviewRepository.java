package com.example.demo.repo;

import com.example.demo.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review ,Long> {
}
