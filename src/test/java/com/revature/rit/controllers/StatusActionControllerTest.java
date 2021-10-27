package com.revature.rit.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.rit.models.issues.Issue;
import com.revature.rit.models.issues.request.IssueInput;
import com.revature.rit.models.issues.request.StatusInput;
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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
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
        Mockito.when(issueRepository.findById(Mockito.anyInt())).then(invocation -> {
            return Optional.of(new Issue(1, "test", "test", "stuff", new User("test", "test", "email", UserLevel.User), LocalDateTime.now(), "test", "test", new HashSet<>()));
        });
        Mockito.when(userRepository.findById(Mockito.anyInt())).then(invocation -> {
            return Optional.of(new User("test", "test", "email", UserLevel.User));
        });
        Mockito.when(statusActionRepository.save(Mockito.any())).then(invocation -> {
            return invocation.getArgument(0);
        });
        StatusInput statusInput = new StatusInput(1, 1, "open");
        String uri = "/status/changeStatus";
        mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(statusInput)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
}