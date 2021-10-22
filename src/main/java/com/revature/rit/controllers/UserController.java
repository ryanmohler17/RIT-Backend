package com.revature.rit.controllers;

import com.revature.rit.models.users.User;
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
        }
    }
}
