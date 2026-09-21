package com.example.demo.DTO;

import com.example.demo.dependentpackage.UserRole;
import lombok.Data;

@Data
public class UserResponse {
    private String id;
    private String fname;
    private String lname;
    private String email;
    private String phone;
    private UserRole role ;
    private AddressDTO  address;
}
