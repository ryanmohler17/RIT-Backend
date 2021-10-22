package com.revature.rit.models.issues;

import com.revature.rit.models.issues.types.IssueStatus;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "status_action")
public class StatusAction extends IssueAction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private IssueStatus status;
}
