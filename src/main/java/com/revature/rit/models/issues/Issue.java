package com.revature.rit.models.issues;

import com.revature.rit.models.issues.types.IssueCategory;
import com.revature.rit.models.issues.types.IssueSeverity;
import com.revature.rit.models.users.User;

import java.time.LocalDateTime;
import java.util.List;

public class Issue {
    private int id;
    private String title;
    private String description;
    private IssueCategory category;
    private User creator;
    private LocalDateTime createdAt;
    private IssueSeverity issueSeverity;
    private List<IssueAction> actions;
    private List<String> labels;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public IssueCategory getCategory() { return category; }

    public void setCategory(IssueCategory category) { this.category = category; }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public IssueSeverity getIssueSeverity() {
        return issueSeverity;
    }

    public void setIssueSeverity(IssueSeverity issueSeverity) {
        this.issueSeverity = issueSeverity;
    }

    public List<IssueAction> getActions() {
        return actions;
    }

    public void setActions(List<IssueAction> actions) {
        this.actions = actions;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }
}
