package com.revature.rit.models.boards;

import com.revature.rit.models.users.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Board {
    private int id;
    private String title;
    private String description;
    private User creator;
    private LocalDateTime createdAt;
    private List<User> users;
    private List<BoardList> lists;
}
