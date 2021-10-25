package com.revature.rit.models.boards;

import com.revature.rit.models.issues.Issue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "list_items")
@Data
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class ListItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "list_item_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "issue_id_fk")
    private Issue issue;

    @ManyToOne
    @JoinColumn(name = "board_list_id_fk")
    private BoardList boardList;
}