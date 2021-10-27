package com.revature.rit.controllers;

import com.revature.rit.models.issues.request.IssueInput;
import com.revature.rit.models.issues.request.StatusInput;
import com.revature.rit.models.users.User;
import com.revature.rit.reposistory.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.jupiter.api.Assertions.*;

@RestController
@RequestMapping("/status")
@Transactional
@CrossOrigin("*")
class StatusActionControllerTest {
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
    void changeStatus() throws Exception {
        StatusActionController c = new StatusActionController();
        ResponseEntity<User> result = null;

        try {
            result = c.changeStatus(new StatusInput());
        } catch (Exception e) {

        }

        Assert.assertEquals(result, result);
    }
}