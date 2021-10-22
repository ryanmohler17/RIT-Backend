package com.revature.rit.models.boards;

import com.revature.rit.models.issues.Issue;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "board_list")
public class BoardList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_list_id")
    private Integer id;

    @Column(name = "title", columnDefinition = "TEXT")
    private String title;

    @Column(name = "board_id_fk")
    @JoinColumn(foreignKey = @ForeignKey(name = "board_id"))
    private Board board;

    private List<Issue> issues;
}
