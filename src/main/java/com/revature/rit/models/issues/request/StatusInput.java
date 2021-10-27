package com.revature.rit.models.issues.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusInput {
    private Integer userId;
    private Integer issueId;
    private String status;
}
