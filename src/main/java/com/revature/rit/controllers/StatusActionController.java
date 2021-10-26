package com.revature.rit.controllers;

import com.revature.rit.models.issues.CommentAction;
import com.revature.rit.models.issues.Issue;
import com.revature.rit.models.issues.IssueAction;
import com.revature.rit.models.issues.StatusAction;
import com.revature.rit.models.issues.request.CommentInput;
import com.revature.rit.models.issues.request.StatusInput;
import com.revature.rit.models.users.User;
import com.revature.rit.reposistory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
@Transactional
public class StatusActionController {
    @Autowired
    StatusActionRepository statusActionRepository;

    @Autowired
    IssueActionRepository issueActionRepository;

    @Autowired
    IssueRepository issueRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/status/changeStatus")
    public ResponseEntity changeStatus(@RequestBody StatusInput statusInput) {
        try {
            Issue issue = issueRepository.findById(statusInput.getIssueId()).get();
            User user = userRepository.findById(statusInput.getUserId()).get();
            IssueAction issueAction = new IssueAction();
            issueAction.setIssue(issue);
            issueAction.setUser(user);
            issueAction.setDoneAt(LocalDateTime.now());
            issueAction.setActionType("Status Change");
            IssueAction createdIssueAction = issueActionRepository.save(issueAction);

            StatusAction newStatus = new StatusAction();
            newStatus.setStatusName(statusInput.getStatus());

            StatusAction _statusAction = statusActionRepository.save(newStatus);
            issue.setIssueStatus(_statusAction.getStatusName());
            issueRepository.save(issue);
            return new ResponseEntity<>(_statusAction, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}