package com.revature.rit.controllers;

import com.revature.rit.models.issues.CommentAction;
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
}
