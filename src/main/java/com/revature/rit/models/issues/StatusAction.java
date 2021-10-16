package com.revature.rit.models.issues;

import com.revature.rit.models.issues.types.IssueStatus;

public class StatusAction extends IssueAction {
    private IssueStatus status;

    public IssueStatus getStatus() {
        return status;
    }

    public void setStatus(IssueStatus status) {
        this.status = status;
    }
}
