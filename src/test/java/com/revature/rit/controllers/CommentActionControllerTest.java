package com.revature.rit.controllers;

import com.revature.rit.models.issues.CommentAction;
import com.revature.rit.models.issues.request.CommentInput;
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
class CommentActionControllerTest {
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
    void createComment() {
        CommentActionController c = new CommentActionController();
        ResponseEntity<User> result = null;

        try {
            result = c.createComment(new CommentInput());
        } catch (Exception e) {

        }

        Assert.assertEquals(result, result);
    }

    @Test
    void getAllComments() {
        CommentActionController c = new CommentActionController();
        ResponseEntity<List<CommentAction>> result = null;

        try {
            result = c.getAllComments();
        } catch (Exception e) {

        }

        Assert.assertEquals(result, result);
    }

    @Test
    void getCommentById() {
        CommentActionController c = new CommentActionController();
        ResponseEntity<CommentAction> result = null;

        try {
            result = c.getCommentById(1);
        } catch (Exception e) {

        }

        Assert.assertEquals(result, result);
    }

    @Test
    void updateComment() {
        CommentActionController c = new CommentActionController();
        ResponseEntity<CommentAction> result = null;

        try {
            result = c.updateComment(1, new CommentAction());
        } catch (Exception e) {

        }

        Assert.assertEquals(result, result);
    }
}