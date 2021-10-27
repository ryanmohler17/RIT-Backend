package com.revature.rit.controllers;

import com.revature.rit.models.boards.BoardList;
import com.revature.rit.models.issues.Issue;
import com.revature.rit.models.issues.request.IssueInput;
import com.revature.rit.models.users.User;
import com.revature.rit.reposistory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.revature.rit.models.issues.types.IssueCategory;
import com.revature.rit.models.issues.types.IssueSeverity;
import com.revature.rit.models.issues.types.IssueStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/issues")
@Transactional
@CrossOrigin("*")
public class IssueController {

    @Autowired
    IssueRepository issueRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BoardListRepository boardListRepository;

    @PostMapping("/createIssue")
    public ResponseEntity createIssue(@RequestBody IssueInput issue) {
        try {
            User user = userRepository.findById(issue.getCreatedBy().getId()).get();
            Issue newIssue = new Issue();

            // Insert Title
            newIssue.setTitle(issue.getTitle());
            // Insert Description
            newIssue.setDescription(issue.getDescription());
            // Insert Category
            newIssue.setCategory(IssueCategory.valueOf(issue.getCategory()).toString());
            // Insert Creator (User)
            newIssue.setCreator(user);
            // Insert Issue Severity
            newIssue.setIssueSeverity(IssueSeverity.valueOf(issue.getSeverity()).toString());
            // Insert Issue Status
            newIssue.setIssueStatus(IssueStatus.valueOf("Open").toString());
            // Insert Created At
            newIssue.setCreatedAt(LocalDateTime.now());

            Issue _issue = issueRepository.save(newIssue);

            return new ResponseEntity<>(_issue, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllIssues")
    public ResponseEntity<List<Issue>> getAllIssues() {
        try {
            List<Issue> issuesList = new ArrayList<Issue>();
            Iterable<Issue> issues = issueRepository.findAll();
            issues.forEach(issuesList::add);
            return new ResponseEntity<>(issuesList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getIssueById/{id}")
    public ResponseEntity<Issue> getIssueById(@PathVariable("id") Integer id) {
        Optional<Issue> issueData = issueRepository.findById(id);

        if (issueData.isPresent()) {
            return new ResponseEntity<>(issueData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/updateIssue/{id}")
    public ResponseEntity<Issue> updateIssue(@PathVariable("id") Integer id, @RequestBody Issue issue) {
        List<String> availableFields = Arrays.asList("title","description","category","issueSeverity","issueStatus","creator");
        Optional<Issue> issueData = issueRepository.findById(id);

        if (issueData.isPresent()) {
            Issue _issue = issueData.get();
            for (String field : availableFields) {
                switch (field){
                    case "title": if (issue.getTitle() != null) _issue.setTitle(issue.getTitle()); break;
                    case "description": if (issue.getDescription() != null) _issue.setDescription(issue.getDescription()); break;
                    case "category": if (issue.getCategory() != null) _issue.setCategory(issue.getCategory()); break;
                    case "issueSeverity": if (issue.getIssueSeverity() != null) _issue.setIssueSeverity(issue.getIssueSeverity()); break;
                    case "issueStatus": if (issue.getIssueStatus() != null) _issue.setIssueStatus(issue.getIssueStatus()); break;
                    case "creator": if (issue.getCreator() != null) _issue.setCreator(issue.getCreator()); break;
                }
            }
            return new ResponseEntity<>(issueRepository.save(_issue), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}