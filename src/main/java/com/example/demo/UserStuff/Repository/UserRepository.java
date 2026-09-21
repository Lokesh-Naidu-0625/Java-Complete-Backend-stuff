package com.example.demo.Repository;

import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


//both repositories are same but use case is different better you should know both
//public interface UserRepository extends CrudRepository
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
