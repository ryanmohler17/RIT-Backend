package com.revature.rit.controllers;

import com.revature.rit.models.users.User;
<<<<<<< HEAD
import com.revature.rit.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
@Transactional
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            User _user = userRepository
                    .save(new User(user.getUsername(), user.getPassword(), user.getEmail(), user.getUserLevel()));
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/getUserById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
        Optional<User> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/users/getByUsername/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {
        Optional<User> userData = userRepository.findByUsername(username);

        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user) {
        Optional<User> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            User _user = userData.get();
            _user.setUsername(user.getUsername());
            _user.setPassword(user.getPassword());
            _user.setEmail(user.getEmail());
            _user.setUserLevel(user.getUserLevel());
            return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
=======
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController implements ObjectController<User> {
    @Override
    public List<User> getAllData() {
        //TODO: Hook into database dao.

        //Ex: users = dao.getAllUsers();
        List<User> users = null;

        return users;
    }

    @Override
    public ResponseEntity<User> getData(int id) {
        //TODO: Hook into database dao.

        //Ex: user = dao.getUser(id);
        User user = null;

        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @Override
    public ResponseEntity addData(HttpServletRequest request, User obj) {
        System.out.println(obj); //Debug

        try {
            //TODO: Create user and insert into database.

            //Ex: dao.addUser(user);

            //TODO: Fix hard-coded url.
            return ResponseEntity.created(new URI("http://localhost:8080/users/" + obj.getId())).build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("There was a problem creating user.");
>>>>>>> master
        }
    }
}
