package com.revature.rit.controllers;

import com.revature.rit.models.issues.Issue;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/issues")
public class IssueController {
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Issue> getAllIssues() {
        //TODO: Hook into database dao.

        //Ex: issues = dao.getAllIssues();
        List<Issue> issues = null;

        return issues;
    }

    @GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Issue> getIssue(@PathVariable int id) {
        //TODO: Hook into database dao.

        //Ex: issue = dao.getIssue(id);
        Issue issue = null;

        if (issue == null) {
            return new ResponseEntity<Issue>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Issue>(issue, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addIssue(@RequestBody Issue issue) {
        System.out.println(issue); //Debug

        try {
            //TODO: Create issue and insert into database.

            //Ex: dao.addIssue(issue);

            return ResponseEntity.created(new URI("http://localhost:8080/issues/" + issue.getId())).build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("There was a problem creating issue.");
        }
    }
}
