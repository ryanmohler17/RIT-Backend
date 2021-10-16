package com.revature.rit.models.issues;

import com.revature.rit.models.issues.IssueAction;

public class CommentAction extends IssueAction {
    private String comment;
    private IssueAction replyTo;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public IssueAction getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(IssueAction replyTo) {
        this.replyTo = replyTo;
    }
}
