package com.example.demo.Service;


import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
//    private List<User> userList = new ArrayList<>();
//    private long nextId = 1L;
    private final UserRepository userRepository;
// Dependency Injection:
// The 'final' keyword only declares the dependency.
// It does not initialize or inject the UserRepository.
//
// Spring needs a constructor to provide the UserRepository.
// We can write the constructor manually, or use Lombok's
// @RequiredArgsConstructor to generate it automatically.
//
// Example:
// @RequiredArgsConstructor
// private final UserRepository userRepository;
//    or else for injecting object of a repository there is another way as follows
//    if we execute the following thing then we dont have to put @RequiredArgsConstructor
//    public UserService(UserRepository userRepository){
//        this.userRepository = userRepository;
//    }

    public List<User> fetchallusers(){
        return userRepository.findAll();
    }

    public String createuser(User user){
//        user.setId(nextId++);
//        on the above line we are incrementing the id of the user automatically
        userRepository.save(user);
//        userList.add(user);
        return "user is added successfully";
    }

//    public User getbyid(Long id){
//        for(User user : userList){
//            if(user.getId().equals(id))
//                return user;
//        }
//        return null;
//    }

    public Optional<User> fetchuser(Long id){
//        return userList.stream()
//                .filter(user -> user.getId().equals(id))
//                .findFirst();
        return userRepository.findById(id);
    }

    public boolean updateuser(Long id, User updateduser){

//        return userList.stream()
//                .filter(user -> user.getId().equals(id))
//                .findFirst()
//                .map(existingUser ->{
//                    existingUser.setfname(updateduser.getFname());
//                    existingUser.setlname(updateduser.getLname());
//                    return true;
//                }).orElse(false);

        // Convert the userList into a Stream so that we can search and process
// the users using Stream API operations.
//
// filter() checks each user and keeps only the user whose ID matches
// the given id.
//
// findFirst() returns the first matching user as an Optional<User>.
// Optional is used because the user may or may not exist.
//
// If a user is found, map() executes the update operation:
// 1. Update the user's first name.
// 2. Update the user's last name.
// 3. Return true to indicate that the update was successful.
//
// If no user is found, map() will not execute and orElse(false)
// returns false.
//
// Overall:
// User found    → update user → return true
// User not found → no update  → return false

        return userRepository.findById(id)
                .map(existinguser -> {
                    existinguser.setfname(updateduser.getFname());
                    existinguser.setlname(updateduser.getLname());
                    userRepository.save(existinguser);
                    return true;
                }).orElse(false);
    }
}
