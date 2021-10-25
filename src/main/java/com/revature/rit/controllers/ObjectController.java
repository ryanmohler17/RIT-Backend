package com.revature.rit.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ObjectController<T> {
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<T> getAllData();

    @GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<T> getData(@PathVariable int id);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity addData(HttpServletRequest request, @RequestBody T obj);
}