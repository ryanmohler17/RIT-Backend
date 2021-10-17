package com.revature.rit.models.issues;

import com.revature.rit.models.issues.types.IssueStatus;
import lombok.Data;

@Data
public class StatusAction extends IssueAction {
    private IssueStatus status;
}
