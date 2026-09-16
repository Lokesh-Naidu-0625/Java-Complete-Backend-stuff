package com.example.demo.DTO;

import com.example.demo.dependentpackage.UserRole;
import lombok.Data;


@Data
public class UserRequest {
    private String fname;
    private String lname;
    private String email;
    private String phone;
    private AddressDTO  address;
}
