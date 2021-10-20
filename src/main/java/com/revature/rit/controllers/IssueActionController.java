package com.revature.rit.controllers;

import com.revature.rit.models.issues.IssueAction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

//TODO: Resolve abstract class POST/GET error
@RestController
@RequestMapping("/issueactions")
public class IssueActionController implements ObjectController<IssueAction> {
    @Override
    public List<IssueAction> getAllData() {
        //TODO: Hook into database dao.

        //Ex: issueAction = dao.getAllIssueActions();
        List<IssueAction> issueAction = null;

        return issueAction;
    }

    @Override
    public ResponseEntity<IssueAction> getData(int id) {
        //TODO: Hook into database dao.

        //Ex: issueAction = dao.getIssueAction(id);
        IssueAction issueAction = null;

        if (issueAction == null) {
            return new ResponseEntity<IssueAction>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<IssueAction>(issueAction, HttpStatus.OK);
    }

    @Override
    public ResponseEntity addData(IssueAction obj) {
        System.out.println(obj); //Debug

        try {
            //TODO: Create issue action and insert into database.

            //Ex: dao.addIssueAction(issueAction);

            //TODO: Fix hard-coded url.
            return ResponseEntity.created(new URI("http://localhost:8080/issueactions/" + obj.getId())).build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("There was a problem creating issue action.");
        }
    }
}
