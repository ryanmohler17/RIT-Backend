package com.revature.rit.models.issues.request;

import com.revature.rit.models.users.User;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class IssueInput {
    private Integer boardListId;
    private String title;
    private String description;
    private String category;
    private User creator;
    private LocalDateTime createdAt;
    private String issueSeverity;
    private String issueStatus;

}
