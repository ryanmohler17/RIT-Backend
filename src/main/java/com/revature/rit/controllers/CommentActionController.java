package com.revature.rit.controllers;

import com.revature.rit.models.issues.CommentAction;
import com.revature.rit.reposistory.CommentActionRepository;
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
public class CommentActionController {

    /*@Autowired
    CommentActionRepository commentActionRepository;

    @PostMapping("/comment/createComment")
    public ResponseEntity<CommentAction> createComment(@RequestBody CommentAction commentAction) {
        try {
            CommentAction _comment = commentActionRepository
                    .save(new CommentAction(commentAction.getComment(), commentAction.getReplyTo()));
            return new ResponseEntity<>(_comment, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/comment/getAllComments")
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

    @GetMapping("/comment/getCommentById/{id}")
    public ResponseEntity<CommentAction> getCommentById(@PathVariable("id") Integer id) {
        Optional<CommentAction> commentData = commentActionRepository.findById(id);

        if (commentData.isPresent()) {
            return new ResponseEntity<>(commentData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/comment/getCommentByReplyToId/{replyTo}")
    public ResponseEntity<CommentAction> getCommentByReplyToId(@PathVariable("replyTo") CommentAction commentAction) {
        Optional<CommentAction> commentData = commentActionRepository.findByReplyToId(commentAction.getReplyTo().getId());

        if (commentData.isPresent()) {
            return new ResponseEntity<>(commentData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/comment/updateComment/{id}")
    public ResponseEntity<CommentAction> updateComment(@PathVariable("id") Integer id, @RequestBody CommentAction commentAction) {
        List<String> availableFields = Arrays.asList("comment","replyTo");
        Optional<CommentAction> commentData = commentActionRepository.findById(id);

        if (commentData.isPresent()) {
            CommentAction _comment = commentData.get();
            for (String field : availableFields) {
                switch (field){
                    case "comment": if (commentAction.getComment() != null) _comment.setComment(commentAction.getComment()); break;
                    case "replyTo": if (commentAction.getReplyTo() != null) _comment.setReplyTo(commentAction.getReplyTo()); break;
                }
            }
            return new ResponseEntity<>(commentActionRepository.save(_comment), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/
}

/*import com.revature.rit.models.issues.CommentAction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/commentactions")
public class CommentActionController implements ObjectController<CommentAction> {
    @Override
    public List<CommentAction> getAllData() {
        //TODO: Hook into database dao.

        //Ex: commentActions = dao.getAllCommentActions();
        List<CommentAction> commentActions = null;

        return commentActions;
    }

    @Override
    public ResponseEntity<CommentAction> getData(int id) {
        //TODO: Hook into database dao.

        //Ex: commentActions = dao.getCommentAction(id);
        CommentAction commentAction = null;

        if (commentAction == null) {
            return new ResponseEntity<CommentAction>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<CommentAction>(commentAction, HttpStatus.OK);
    }

    @Override
    public ResponseEntity addData(HttpServletRequest request, CommentAction obj) {
        System.out.println(obj); //Debug

        try {
            //TODO: Create comment action and insert into database.

            //Ex: dao.addCommentAction(commentAction);

            //TODO: Fix hard-coded url.
            return ResponseEntity.created(new URI("http://localhost:8080/commentactions/" + obj.getId())).build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("There was a problem creating comment action.");
        }
    }
}*/
