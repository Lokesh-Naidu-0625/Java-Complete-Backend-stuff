package com.example.demo.Entity;


import com.example.demo.dependentpackage.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity(name="user_table")
public class User {

    public void setlname(String lname) {
        this.lname = lname;
    }

    public void setfname(String fname) {
        this.fname = fname;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fname;
    private String lname;
    private String email;
    private String phone;
    private UserRole role = UserRole.CUSTOMER ;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    // One User has exactly one Address.
// cascade = ALL → operations on User also apply to Address.
// orphanRemoval = true → removes Address when it is no longer associated with User.
    @JoinColumn(name="address_id", referencedColumnName = "id")
    // Creates a foreign key column "address_id" in this table,
// which references the "id" column of Address.
    private Address address;


    @CreationTimestamp
    private LocalDateTime createAT;
    // Automatically stores the date & time when the record is created.

    @UpdateTimestamp
    private LocalDateTime updatedAT;
    // Automatically updates the date & time whenever the record is modified

//    public User(Long id, String fname, String lname) {
//        this.id = id;
//        this.fname = fname;
//        this.lname = lname;
//    }
//
//    public User (){
//
//    }

}
