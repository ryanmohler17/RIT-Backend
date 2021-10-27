package com.revature.rit.models.issues.request;

import lombok.Data;

@Data
public class CommentInput {
    private Integer userId;
    private Integer issueId;
    private String comment;
    private Integer replyTo;
}
