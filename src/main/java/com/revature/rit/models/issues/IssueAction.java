package com.revature.rit.models.issues;

import com.revature.rit.models.users.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class IssueAction {
    private int id;
    private User user;
    private Issue issue;
    private LocalDateTime doneAt;
}
