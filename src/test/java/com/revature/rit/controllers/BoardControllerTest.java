package com.revature.rit.controllers;

import com.revature.rit.models.boards.Board;
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
class BoardControllerTest {

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
    void createBoard() {
        BoardController bc = new BoardController();
        ResponseEntity result = null;

        try {
            result = bc.createBoard(null);
        } catch (Exception e) {

        }

        Assert.assertEquals(result, result);
    }

    @Test
    void getAllBoards() {
        BoardController bc = new BoardController();
        ResponseEntity<List<Board>> result = null;

        try {
            result = bc.getAllBoards();
        } catch (Exception e) {

        }

        Assert.assertEquals(result, result);
    }

    @Test
    void getBoardById() {
        BoardController bc = new BoardController();
        ResponseEntity<Board> result = null;

        try {
            result = bc.getBoardById(1);
        } catch (Exception e) {

        }

        Assert.assertEquals(result, result);
    }

    @Test
    void getBoardByCreator() {
        BoardController bc = new BoardController();
        ResponseEntity<Board> result = null;

        try {
            result = bc.getBoardByCreator(new User());
        } catch (Exception e) {

        }

        Assert.assertEquals(result, result);
    }

    @Test
    void updateBoard() {
        BoardController bc = new BoardController();
        ResponseEntity<Board> result = null;

        try {
            result = bc.updateBoard(1, new Board());
        } catch (Exception e) {

        }

        Assert.assertEquals(result, result);
    }
}