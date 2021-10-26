package com.revature.rit.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.rit.models.users.User;
import com.revature.rit.models.users.UserLevel;
import com.revature.rit.reposistory.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

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
                MockMvcRequestBuilders.post("/api/users/createUser")
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
        String uri = "/api/users/getAllUsers";
        mockMvc.perform(
                MockMvcRequestBuilders.get(uri))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                //.andExpect(jsonPath("$.").exists())
                .andDo(MockMvcResultHandlers.print());
    }
}