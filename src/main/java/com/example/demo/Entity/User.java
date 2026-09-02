package com.example.demo.Entity;


import com.example.demo.dependentpackage.UserRole;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

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
