package com.revature.rit.models.boards;

import com.fasterxml.jackson.annotation.*;
import com.revature.rit.models.issues.Issue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "board_list")
@Data
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class BoardList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_list_id")
    private Integer id;

    @Column(name = "title", columnDefinition = "TEXT")
    private String title;

    @ManyToOne
    @JoinColumn(name = "board_id_fk")
    private Board board;

    @ManyToMany
    @JoinTable(
            name = "list_items",
            joinColumns = {@JoinColumn(name = "board_list_id_fk")},
            inverseJoinColumns = {@JoinColumn(name = "issue_id_fk")}
    )
    private List<Issue> issues;

    public BoardList(String title, Board board) {
        this.title = title;
        this.board = board;
    }

<<<<<<< HEAD
    /*@OneToMany(mappedBy = "boardList")
    @JsonIgnore
    private Set<ListItems> issuesList = new HashSet<>();*/
=======

>>>>>>> 4649c0ff55abd0d387f2d63596dc0d16209e6fab
}
