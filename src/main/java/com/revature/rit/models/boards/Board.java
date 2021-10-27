package com.revature.rit.models.boards;

import com.revature.rit.models.users.User;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "board")
@Data
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
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
    @JoinColumn(name = "user_id_fk")
    private User creator;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToMany
    @JoinTable(
            name = "board_users",
            joinColumns = {@JoinColumn(name = "board_id_fk")},
            inverseJoinColumns = {@JoinColumn(name = "user_id_fk")}
    )
    private List<User> users;

    @OneToMany(mappedBy = "board")
    private List<BoardList> lists;

    public Board(String title, String description, User user) {
        this.title = title;
        this.description = description;
        this.creator = user;
        this.createdAt = LocalDateTime.now();
    }
}
