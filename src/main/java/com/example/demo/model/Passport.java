package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Passport implements Serializable {
    @Id
    private  long  id;
    private String number;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
    @JsonIgnoreProperties(value = "passport")
    private Student student;

    public Passport( long id, String number) {
        this.id= id;
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("Passport{id=%d, number='%s'}", id, number);
    }
}
