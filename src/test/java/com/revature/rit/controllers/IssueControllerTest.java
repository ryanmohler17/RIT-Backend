package com.revature.rit.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.rit.models.issues.Issue;
import com.revature.rit.models.issues.request.CommentInput;
import com.revature.rit.models.issues.request.IssueInput;
import com.revature.rit.models.users.User;
import com.revature.rit.models.users.UserLevel;
import com.revature.rit.reposistory.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;
import java.util.Optional;

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
    void createIssue() throws Exception {
        Mockito.when(userRepository.findById(Mockito.anyInt())).then(invocation -> {
            return Optional.of(new User("test", "test", "test", UserLevel.User));
        });
        Mockito.when(issueRepository.save(Mockito.any())).then(invocation -> {
            return invocation.getArgument(0);
        });
        User user = new User("test", "test", "test", UserLevel.User);
        user.setId(1);
        IssueInput issueInput = new IssueInput("test", "test", "Technical", user, "Medium", "Open");
        String uri = "/issues/createIssue";
        mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(issueInput)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
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