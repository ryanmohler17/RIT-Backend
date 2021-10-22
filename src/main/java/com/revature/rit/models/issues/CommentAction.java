package com.revature.rit.models.issues;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "comments_action")
public class CommentAction extends IssueAction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Integer commentId;

    @Column(name = "comment_action", columnDefinition = "TEXT")
    private String comment;

    @Column(name = "reply_to")
    @JoinColumn(foreignKey = @ForeignKey(name = "comment_id"))
    private IssueAction replyTo;
}
