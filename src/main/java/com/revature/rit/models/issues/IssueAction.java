package com.revature.rit.models.issues;

import com.revature.rit.models.users.User;

import java.time.LocalDateTime;

public abstract class IssueAction {
    private int id;
    private User user;
    private Issue issue;
    private LocalDateTime doneAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public LocalDateTime getDoneAt() {
        return doneAt;
    }

    public void setDoneAt(LocalDateTime doneAt) {
        this.doneAt = doneAt;
    }
}
