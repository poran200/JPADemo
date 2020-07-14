package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.CascadeType.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Review {
    @Id
    private  long  id;
    private   long rating;
    private  String comment;
    @CreationTimestamp
    private  LocalDateTime createDate;
    @UpdateTimestamp
    private  LocalDateTime updateDate;
    @ManyToOne(cascade = {PERSIST,MERGE,DETACH,REFRESH},fetch = FetchType.LAZY)
    @JoinColumn
    @JsonIgnoreProperties(value ="reviewList")
    private  Course course;

    public Review(long id, long rating, String comment) {
        this.id = id;
        this.rating = rating;
        this.comment= comment;
    }

    public Review(Review review) {
        this.id = review.getId();
        this.rating = review.getRating();
        this.comment= review.getComment();
    }

    @Override
    public String toString() {
        return String.format("Review{id=%d, rating=%d, comment='%s', createDate=%s, updateDate=%s}",
                id,
                rating,
                comment,
                createDate,
                updateDate);
    }
}
