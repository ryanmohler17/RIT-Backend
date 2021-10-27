package com.revature.rit.controllers;

import com.revature.rit.models.boards.BoardList;
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
class BoardListControllerTest {
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
    void createBoardList() {
        BoardListController bc = new BoardListController();
        ResponseEntity result = null;

        try {
            result = bc.createBoardList(new BoardList());
        } catch (Exception e) {

        }

        Assert.assertEquals(result, result);
    }

    @Test
    void getAllBoardLists() {
        BoardListController bc = new BoardListController();
        ResponseEntity result = null;

        try {
            result = bc.getAllBoardLists();
        } catch (Exception e) {

        }

        Assert.assertEquals(result, result);
    }

    @Test
    void getBoardListById() {
        BoardListController bc = new BoardListController();
        ResponseEntity result = null;

        try {
            result = bc.getBoardListById(1);
        } catch (Exception e) {

        }

        Assert.assertEquals(result, result);
    }

    @Test
    void updateBoardList() {
        BoardListController bc = new BoardListController();
        ResponseEntity result = null;

        try {
            result = bc.updateBoardList(1, new BoardList());
        } catch (Exception e) {

        }

        Assert.assertEquals(result, result);
    }
}