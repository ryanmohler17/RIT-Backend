package com.revature.rit.models.issues;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.revature.rit.models.boards.BoardList;
<<<<<<< HEAD
import com.revature.rit.models.boards.ListItems;
=======
>>>>>>> 4649c0ff55abd0d387f2d63596dc0d16209e6fab
import com.revature.rit.models.users.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "issues")
@Data
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="issue_id")
    private Integer id;

    @Column(name = "issue_title", columnDefinition = "TEXT")
    private String title;

    @Column(name = "issue_description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "issue_category")
    private String category;

    @ManyToOne
    @JoinColumn(name = "issue_creator")
    private User creator;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "issue_severity")
    private String issueSeverity;

    @Column(name = "issue_status")
    private String issueStatus;

    @ManyToMany(mappedBy = "issues")
    private Set<BoardList> boardsList = new HashSet<>();
<<<<<<< HEAD

    /*@OneToMany(mappedBy = "issue")
    @JsonIgnore
    private Set<ListItems> boardsList = new HashSet<>();*/
=======
>>>>>>> 4649c0ff55abd0d387f2d63596dc0d16209e6fab
}
