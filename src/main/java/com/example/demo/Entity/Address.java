package com.example.demo.Entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@Entity(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipcode;


    @CreationTimestamp
    private LocalDateTime createAT;
    // Automatically stores the date & time when the record is created.

    @UpdateTimestamp
    private LocalDateTime updatedAT;
    // Automatically updates the date & time whenever the record is modified.
}
