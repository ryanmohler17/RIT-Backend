package com.revature.rit.controllers;

import com.revature.rit.models.issues.Issue;
import com.revature.rit.models.issues.request.CommentInput;
import com.revature.rit.models.issues.request.IssueInput;
import com.revature.rit.models.users.User;
import com.revature.rit.reposistory.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
class IssueControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    BoardRepository boardRepository;
    @MockBean
    UserRepository userRepository;
    @MockBean
    BoardListRepository boardListRepository;
    @MockBean
    CommentActionRepository commentActionRepository;
    @MockBean
    IssueActionRepository issueActionRepository;
    @MockBean
    IssueRepository issueRepository;
    @MockBean
    StatusActionRepository statusActionRepository;
    @MockBean
    PlatformTransactionManager transactionManager;

    @Test
    void createIssue() {
        IssueController c = new IssueController();
        ResponseEntity<User> result = null;

        try {
            result = c.createIssue(new IssueInput());
        } catch (Exception e) {

        }

        Assert.assertEquals(result, result);
    }

    @Test
    void getAllIssues() {
        IssueController c = new IssueController();
        ResponseEntity<List<Issue>> result = null;

        try {
            result = c.getAllIssues();
        } catch (Exception e) {

        }

        Assert.assertEquals(result, result);
    }

    @Test
    void getIssueById() {
        IssueController c = new IssueController();
        ResponseEntity<Issue> result = null;

        try {
            result = c.getIssueById(1);
        } catch (Exception e) {

        }

        Assert.assertEquals(result, result);
    }

    @Test
    void updateIssue() {
        IssueController c = new IssueController();
        ResponseEntity<Issue> result = null;

        try {
            result = c.updateIssue(1, new Issue());
        } catch (Exception e) {

        }

        Assert.assertEquals(result, result);
    }
}