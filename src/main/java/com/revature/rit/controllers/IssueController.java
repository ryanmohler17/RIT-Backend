package com.revature.rit.controllers;

import com.revature.rit.models.boards.BoardList;
import com.revature.rit.models.boards.ListItems;
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

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
@Transactional
public class IssueController {

    @Autowired
    IssueRepository issueRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BoardListRepository boardListRepository;

    @Autowired
    ListItemsRepository listItemsRepository;

    @PostMapping("/issues/createIssue")
    public ResponseEntity createIssue(@RequestBody IssueInput issue) {
        try {
            User user = userRepository.findById(issue.getCreator().getId()).get();
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
            newIssue.setIssueSeverity(IssueSeverity.valueOf(issue.getIssueSeverity()).toString());
            // Insert Issue Status
            newIssue.setIssueStatus(IssueStatus.valueOf("Open").toString());
            // Insert Created At
            newIssue.setCreatedAt(LocalDateTime.now());
            Issue _issue = issueRepository.save(newIssue);

            // If BoardList then Create Relationship
            if (issue.getBoardListId() != null) {
                BoardList boardList = boardListRepository.findById(issue.getBoardListId()).get();
                ListItems newListItem = new ListItems();
                newListItem.setIssue(_issue);
                newListItem.setBoardList(boardList);
                listItemsRepository.save(newListItem);
            }
            return new ResponseEntity<>(_issue, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/issues/getAllIssues")
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

    @GetMapping("/issues/getIssueById/{id}")
    public ResponseEntity<Issue> getIssueById(@PathVariable("id") Integer id) {
        Optional<Issue> issueData = issueRepository.findById(id);

        if (issueData.isPresent()) {
            return new ResponseEntity<>(issueData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/issues/updateIssue/{id}")
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

/*import com.revature.rit.models.issues.Issue;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public ResponseEntity addData(HttpServletRequest request, Issue obj) {
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
}*/
