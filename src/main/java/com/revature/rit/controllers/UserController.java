package com.revature.rit.controllers;

import com.revature.rit.models.users.User;
import com.revature.rit.reposistory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
@Transactional
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/users/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            User _user = userRepository
                    .save(new User(user.getUsername(), user.getPassword(), user.getEmail(), user.getUserLevel()));
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> userList = new ArrayList<User>();
            Iterable<User> users = userRepository.findAll();
            users.forEach(userList::add);
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/getUserById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
        Optional<User> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/users/getUserByUsername/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {
        Optional<User> userData = userRepository.findByUsername(username);

        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/users/updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
        List<String> availableFields = Arrays.asList("username","password","email","userLevel");
        Optional<User> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            User _user = userData.get();
            for (String field : availableFields) {
                switch (field){
                    case "username": if (user.getUsername() != null) _user.setUsername(user.getUsername()); break;
                    case "password": if (user.getPassword() != null) _user.setPassword(user.getPassword()); break;
                    case "email": if (user.getEmail() != null) _user.setEmail(user.getEmail()); break;
                    case "userLevel": if (user.getUserLevel() != null) _user.setUserLevel(user.getUserLevel()); break;
                }
            }
            return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

/*import com.revature.rit.models.users.User;
import org.springframework.http.HttpStatus;
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
        }
    }
}*/
