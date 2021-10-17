package com.revature.rit.models.issues;

import lombok.Data;

@Data
public class CommentAction extends IssueAction {
    private String comment;
    private IssueAction replyTo;
}
