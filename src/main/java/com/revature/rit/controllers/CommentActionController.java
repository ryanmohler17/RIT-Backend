package com.revature.rit.controllers;

import com.revature.rit.models.issues.CommentAction;
import com.revature.rit.models.issues.Issue;
import com.revature.rit.models.issues.IssueAction;
import com.revature.rit.models.issues.request.CommentInput;
import com.revature.rit.models.users.User;
import com.revature.rit.reposistory.CommentActionRepository;
import com.revature.rit.reposistory.IssueActionRepository;
import com.revature.rit.reposistory.IssueRepository;
import com.revature.rit.reposistory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comment")
@Transactional
@CrossOrigin("*")
public class CommentActionController {

    @Autowired
    CommentActionRepository commentActionRepository;

    @Autowired
    IssueActionRepository issueActionRepository;

    @Autowired
    IssueRepository issueRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/createComment")
    public ResponseEntity createComment(@RequestBody CommentInput commentInput) {
        try {
            Issue issue = issueRepository.findById(commentInput.getIssueId()).get();
            User user = userRepository.findById(commentInput.getUserId()).get();
            IssueAction issueAction = new IssueAction();
            issueAction.setIssue(issue);
            issueAction.setUser(user);
            issueAction.setDoneAt(LocalDateTime.now());
            issueAction.setActionType("Comment");
            IssueAction createdIssueAction = issueActionRepository.save(issueAction);

            CommentAction newComment = new CommentAction();
            // Insert Comment
            newComment.setComment(commentInput.getComment());
            if (commentInput.getReplyTo() != null) {
                CommentAction commentAction = commentActionRepository.findById(commentInput.getReplyTo()).get();
                newComment.setParentComment(commentAction);
            }
            newComment.setIssueAction(createdIssueAction);

            CommentAction _comment = commentActionRepository.save(newComment);

            return new ResponseEntity<>(_comment, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllComments")
    public ResponseEntity<List<CommentAction>> getAllComments() {
        try {
            List<CommentAction> commentList = new ArrayList<CommentAction>();
            Iterable<CommentAction> comments = commentActionRepository.findAll();
            comments.forEach(commentList::add);
            return new ResponseEntity<>(commentList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getCommentById/{id}")
    public ResponseEntity<CommentAction> getCommentById(@PathVariable("id") Integer id) {
        Optional<CommentAction> commentData = commentActionRepository.findById(id);

        if (commentData.isPresent()) {
            return new ResponseEntity<>(commentData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/updateComment/{id}")
    public ResponseEntity<CommentAction> updateComment(@PathVariable("id") Integer id, @RequestBody CommentAction commentAction) {
        List<String> availableFields = Arrays.asList("comment");
        Optional<CommentAction> commentData = commentActionRepository.findById(id);

        if (commentData.isPresent()) {
            CommentAction _comment = commentData.get();
            for (String field : availableFields) {
                switch (field){
                    case "comment": if (commentAction.getComment() != null) _comment.setComment(commentAction.getComment()); break;
                }
            }
            return new ResponseEntity<>(commentActionRepository.save(_comment), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}