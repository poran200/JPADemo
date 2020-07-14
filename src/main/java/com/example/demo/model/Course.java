package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Course {
    @Id
    private  long  id;
    private   String title;
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "course")
    private  List<Review> reviewList;

    @ManyToMany(mappedBy = "courseList")
    List<Student> studentList ;
    public  void  addReview(Review review){
        if (reviewList == null){
            reviewList = new ArrayList<>();
        }
         reviewList.add(review);
        review.setCourse(this);
    }
    public void addStudent(Student student){
        if ( studentList== null)
             studentList= new ArrayList<>();
         studentList.add(student);
    }

    @Override
    public String toString() {
        return String.format("Course{id=%d, title='%s'}", id, title);
    }
}
