package com.revature.rit.models.issues;

import com.revature.rit.models.issues.types.IssueCategory;
import com.revature.rit.models.issues.types.IssueSeverity;
import com.revature.rit.models.users.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
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
}
