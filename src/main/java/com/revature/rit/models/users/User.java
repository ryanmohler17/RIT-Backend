package com.revature.rit.models.users;

//import java.awt.*;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private int id;
    private LocalDateTime registerTime;
    private String username;
    private String password;
    private String email;
    //private Image avatar; TODO: Determine what datatype to store the avatar in.
    private UserLevel userLevel;
}
