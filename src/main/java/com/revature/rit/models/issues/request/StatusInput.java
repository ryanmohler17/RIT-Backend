package com.revature.rit.models.issues.request;

import lombok.Data;

@Data
public class StatusInput {
    private Integer userId;
    private Integer issueId;
    private String status;
}
