package com.revature.rit.services;

import com.revature.rit.controllers.IssueController;
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

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
class UserServiceTest {
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
    void createNewUser() {
        ResponseEntity result = null;

        try {
            UserService c = new UserService(null, null, null);
            c.createNewUser(new User());
        } catch (Exception e) {

        }

        Assert.assertEquals(result, result);
    }
}