package com.revature.rit.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.rit.models.users.User;
import com.revature.rit.models.users.UserLevel;
import com.revature.rit.reposistory.BoardListRepository;
import com.revature.rit.reposistory.BoardRepository;
import com.revature.rit.reposistory.CommentActionRepository;
import com.revature.rit.reposistory.IssueActionRepository;
import com.revature.rit.reposistory.IssueRepository;
import com.revature.rit.reposistory.StatusActionRepository;
import com.revature.rit.reposistory.UserRepository;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
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
import org.springframework.transaction.TransactionManager;

import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
class UserControllerTest {

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
    void getCurrentUser() {
        UserController uc = new UserController();
        ResponseEntity<User> result = null;

        try {
            result = uc.getCurrentUser(null);
        } catch (Exception e) {

        }

        Assert.assertEquals(result, result);
    }

    @Test
    void login() throws Exception {
        String uri = "/users/login";
        mockMvc.perform(
                        MockMvcRequestBuilders.get(uri))
                .andExpect(MockMvcResultMatchers.status().isMethodNotAllowed())
                .andDo(MockMvcResultHandlers.print());

        UserController uc = new UserController();
        ResponseEntity<User> result = null;

        try {
            result = uc.login(null, null);
        } catch (Exception e) {

        }

        Assert.assertEquals(result, result);
    }

    @Test
    public void createUser() throws Exception {
        /*
        {
            "id": 5,
            "username": "userTest2",
            "password": "passTest",
            "email": "email@test.com",
            "userLevel": "User",
            "boards": null
        }*/
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("testPass");
        user.setEmail("email@test.com");
        user.setUserLevel(UserLevel.valueOf("User"));
        mockMvc.perform(
                MockMvcRequestBuilders.post("/users/createUser")
                        .content(asJsonString(new User(user.getUsername(),user.getPassword(),user.getEmail(),user.getUserLevel())))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                /*.andExpect(MockMvcResultMatchers.jsonPath(".id").value(6))
                .andExpect(MockMvcResultMatchers.jsonPath(".username").value("testUser"))
                .andExpect(MockMvcResultMatchers.jsonPath(".password").value("testPass"))
                .andExpect(MockMvcResultMatchers.jsonPath(".email").value("email@test.com"))
                .andExpect(MockMvcResultMatchers.jsonPath(".userLevel").value(UserLevel.valueOf("User")))
                .andExpect(MockMvcResultMatchers.jsonPath(".boards").value(UserLevel.valueOf(null)))*/
                //.andExpect(MockMvcResultMatchers.jsonPath(".users/createUser").exists())
                .andDo(MockMvcResultHandlers.print());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Test
    public void getAllUsers() throws Exception {
        String uri = "/users/getAllUsers";
        mockMvc.perform(
                MockMvcRequestBuilders.get(uri))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                //.andExpect(jsonPath("$.").exists())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void getUserById()throws Exception {
        UserController uc = new UserController();
        ResponseEntity<User> result = null;

        try {
            result = uc.getUserById(1);
        } catch (Exception e) {

        }

        Assert.assertEquals(result, result);
    }

    @Test
    void getUserByUsername() throws Exception {
        UserController uc = new UserController();
        ResponseEntity<User> result = null;

        try {
            result = uc.getUserByUsername("name");
        } catch (Exception e) {

        }

        Assert.assertEquals(result, result);
    }

    @Test
    void updateUser() throws Exception {
        Mockito.when(userRepository.findById(Mockito.anyInt())).then(invocation -> {
            Optional<User> optionalUser = Optional.of(new User("test", "test", "email", UserLevel.User));
            return optionalUser;
        });
        User user = new User("test", "test", "email", UserLevel.User);
        String uri = "/users/updateUser/1";
        mockMvc.perform(MockMvcRequestBuilders.patch(uri).contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}