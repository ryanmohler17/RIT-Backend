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
public class IssueController implements ObjectController<Issue> {
    @Override
    public List<Issue> getAllData() {
        //TODO: Hook into database dao.

        //Ex: issues = dao.getAllIssues();
        List<Issue> issues = null;

        return issues;
    }

    @Override
    public ResponseEntity<Issue> getData(int id) {
        //TODO: Hook into database dao.

        //Ex: issue = dao.getIssue(id);
        Issue issue = null;

        if (issue == null) {
            return new ResponseEntity<Issue>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Issue>(issue, HttpStatus.OK);
    }

    @Override
    public ResponseEntity addData(Issue obj) {
        System.out.println(obj); //Debug

        try {
            //TODO: Create issue and insert into database.

            //Ex: dao.addIssue(issue);

            //TODO: Fix hard-coded url.
            return ResponseEntity.created(new URI("http://localhost:8080/issues/" + obj.getId())).build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("There was a problem creating issue.");
        }
    }
}
