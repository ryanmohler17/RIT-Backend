package com.revature.rit.models.boards;

import com.revature.rit.models.issues.Issue;

import java.util.List;

public class BoardList {
    private int id;
    private String title;
    private List<Issue> issues;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }
}
