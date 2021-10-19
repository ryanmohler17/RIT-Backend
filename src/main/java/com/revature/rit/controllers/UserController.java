package com.revature.rit.controllers;

import com.revature.rit.models.users.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers() {
        //TODO: Hook into database dao.

        //Ex: users = dao.getAllUsers();
        List<User> users = null;

        return users;
    }

    @GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable int id) {
        //TODO: Hook into database dao.

        //Ex: user = dao.getUser(id);
        User user = null;

        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addUser(@RequestBody User user) {
        System.out.println(user); //Debug

        try {
            //TODO: Create user and insert into database.

            //Ex: dao.addUser(user);

            return ResponseEntity.created(new URI("http://localhost:8080/users/" + user.getId())).build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("There was a problem creating user.");
        }
    }
}
