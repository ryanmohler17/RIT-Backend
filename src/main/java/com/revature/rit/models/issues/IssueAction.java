package com.revature.rit.models.issues;

import com.revature.rit.models.users.User;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Table(name = "issues_action")
public abstract class IssueAction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_action_id")
    private Integer id;

    @Column(name = "user_id_fk")
    @JoinColumn(foreignKey = @ForeignKey(name = "user_id"))
    private User user;

    @Column(name = "issue_id_fk")
    @JoinColumn(foreignKey = @ForeignKey(name = "issue_id"))
    private Issue issue;

    @Column(name = "done_at")
    private LocalDateTime doneAt;
}
