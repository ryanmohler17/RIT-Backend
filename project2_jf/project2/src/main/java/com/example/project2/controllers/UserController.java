package com.example.project2.controllers;

import com.example.project2.entities.User;
import com.example.project2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/users")
    public List<User> findAll(){
        return userService.findAll();
    }
    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable("userId") Integer id){
        User user = userService.findByID(id);
        userService.delete(user);
    }


}
