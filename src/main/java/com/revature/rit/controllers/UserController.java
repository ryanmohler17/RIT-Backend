package com.revature.rit.controllers;

import com.revature.rit.models.users.User;
import com.revature.rit.reposistory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@Transactional
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/current")
    public ResponseEntity getCurrentUser(HttpServletRequest request) {
        Cookie cookie = WebUtils.getCookie(request, "id");
        if (cookie == null) {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        } else {
            return new ResponseEntity(userRepository.findById(Integer.parseInt(cookie.getValue())).get(), HttpStatus.OK);
        }
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user, HttpServletResponse response) {
        Optional<User> checkOpt = userRepository.findByUsername(user.getUsername());
        if (!checkOpt.isPresent()) {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        } else {
            User check = checkOpt.get();
            if (check.getPassword().equals(user.getPassword())) {
                Cookie cookie = new Cookie("id", check.getId().toString());
                response.addCookie(cookie);
                return new ResponseEntity(HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.FORBIDDEN);
            }
        }
    }

    @PostMapping("/createUser")
    public ResponseEntity createUser(@RequestBody User user) {
        try {
            User _user = userRepository
                    .save(new User(user.getUsername(), user.getPassword(), user.getEmail(), user.getUserLevel()));
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllUsers")
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

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
        Optional<User> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getUserByUsername/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {
        Optional<User> userData = userRepository.findByUsername(username);

        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/updateUser/{id}")
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