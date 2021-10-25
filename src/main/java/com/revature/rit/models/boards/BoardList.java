package com.revature.rit.models.boards;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.*;
import java.util.HashSet;
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

    public BoardList(String title, Board board) {
        this.title = title;
        this.board = board;
    }

    @OneToMany(mappedBy = "boardList")
    @JsonIgnore
    private Set<ListItems> issuesList = new HashSet<>();
}
