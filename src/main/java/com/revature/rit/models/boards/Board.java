package com.revature.rit.models.boards;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.revature.rit.models.users.User;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@Table(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private int id;

    @Column(name = "board_title", columnDefinition = "TEXT")
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    //@Column(name = "creator")
    @JoinColumn(foreignKey = @ForeignKey(name = "user_id"))
    private User creator;

    @Column(name = "created_at")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", shape = JsonFormat.Shape.STRING)
    private LocalDateTime createdAt;

    public Board(String title, String description, Integer creatorId, LocalDateTime createdAt) {
        this.title = title;
        this.description = description;
        this.creator.setId(creatorId);
        this.createdAt = createdAt;
    }

    /*private List<User> users;
    private List<BoardList> lists;*/
}
