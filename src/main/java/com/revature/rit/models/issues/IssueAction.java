package com.revature.rit.models.issues;

import com.revature.rit.models.users.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "issues_action")
@Data
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class IssueAction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_action_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id_fk")
    private User user;

    @ManyToOne
    @JoinColumn(name = "issue_id_fk")
    private Issue issue;

    @Column(name = "done_at")
    private LocalDateTime doneAt;

    @Column(name = "action_type")
    private String actionType;
}
