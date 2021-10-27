package com.revature.rit.models.issues.request;

import com.revature.rit.models.users.User;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class IssueInput {
    private String title;
    private String description;
    private String category;
    private User createdBy;
    private String severity;
    private String status;

}
