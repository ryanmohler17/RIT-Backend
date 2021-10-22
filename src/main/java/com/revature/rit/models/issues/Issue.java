package com.revature.rit.models.issues;

import com.revature.rit.models.issues.types.IssueCategory;
import com.revature.rit.models.issues.types.IssueSeverity;
import com.revature.rit.models.users.User;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Table(name = "issues")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="issue_id")
    private Integer id;

    @Column(name = "issue_title", columnDefinition = "TEXT")
    private String title;

    @Column(name = "issue_description", columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private IssueCategory category;

    @ManyToOne
    @Column(name = "issue_creator")
    @JoinColumn(foreignKey = @ForeignKey(name = "user_id"))
    private User creator;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private IssueSeverity issueSeverity;

    private List<IssueAction> actions;
    private List<String> labels;
}
