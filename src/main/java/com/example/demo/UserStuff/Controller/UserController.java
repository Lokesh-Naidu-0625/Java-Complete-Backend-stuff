package com.example.demo.Controller;


import java.util.ArrayList;
import java.util.List;

import com.example.demo.DTO.UserRequest;
import com.example.demo.DTO.UserResponse;
import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor

//@RequestMapping("/api/user")
//like if we use request mapping like this for the next mapping which are inside
// the block doest required for full url like /api/user
//example if we use requestmapping here out side the block the the following
// mappings can we written inside the block as
//@PostMapping
//@PutMapping("/{id}")
//like wise
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<String> root(){
        return ResponseEntity.ok("Hi there springboot is working fine now");
    }


    // @GetMapping is a shortcut for @RequestMapping with HTTP method GET.
// It tells Spring to execute this controller method whenever a GET
// request is sent to /api/users.
//
// The following two annotations are functionally equivalent:
//
// @GetMapping("/api/users")
//
// @RequestMapping(value = "/api/users", method = RequestMethod.GET)
//
// @RequestMapping is the more general annotation and can be used
// with different HTTP methods such as GET, POST, PUT and DELETE.
//
// @GetMapping, @PostMapping, @PutMapping, @DeleteMapping and
// @PatchMapping are specialized/shortcut annotations provided
// by Spring for better readability.

    // Modern and preferred way:
    @GetMapping("/api/users")

// Equivalent older/general way:
// @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public ResponseEntity<List<UserResponse>> getallusers(){
        // ResponseEntity.ok() is a static factory method.
// It internally creates and returns a ResponseEntity object
// with HTTP status 200 OK and the given data as the response body.
// We don't explicitly use "new" because the factory method handles
// the object creation for us.



//        return ResponseEntity.ok(userService.fetchallusers());


        // Here, we explicitly create a ResponseEntity object using the constructor.
// The first argument is the response body (users),
// and the second argument is the HTTP status (200 OK).
// This is functionally similar to ResponseEntity.ok(...).
        return new ResponseEntity<>(userService.fetchallusers(),HttpStatus.OK);
    }


    @PostMapping("/api/users")
    public ResponseEntity<String> adduser(@RequestBody UserRequest userRequest){
        userService.createuser(userRequest);
        return ResponseEntity.ok("user is added successfully");
    }

    @GetMapping("/api/user/{id}")
    public ResponseEntity<UserResponse> getuserbyid(@PathVariable Long id){
//        return userService.getbyid(id);
//        User user = userService.getbyid(id);
//        if (user == null){
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(user);

        return userService.fetchuser(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity<String> updatedUser(@PathVariable Long id, @RequestBody UserRequest updateUserRequest){
        boolean bol = userService.updateuser(id,updateUserRequest);
        if(bol)
            return ResponseEntity.ok("user is updated successfully");
        return ResponseEntity.notFound().build();
    }
}
