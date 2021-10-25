package com.revature.rit.models.issues;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "comments_action")
@Data
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class CommentAction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Integer commentId;

    @Column(name = "comment_action", columnDefinition = "TEXT")
    private String comment;

    @ManyToOne
    private CommentAction parentComment;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "reply_to")
    private Collection<CommentAction> childComment;

    @OneToOne
    @JoinColumn(name = "issue_action_id_fk")
    private IssueAction issueAction;

    public CommentAction(String comment, CommentAction parentComment, Collection<CommentAction> childComment, IssueAction issueAction) {
        this.comment = comment;
        this.parentComment = parentComment;
        this.childComment = childComment;
        this.issueAction = issueAction;
    }
}
