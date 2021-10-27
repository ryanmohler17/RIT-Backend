package com.revature.rit.models.users;

import com.revature.rit.models.boards.Board;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Integer id;

    //private LocalDateTime registerTime; TODO: Do we really need this property?

    @Column(name="user_username")
    @NonNull private String username;

    @Column(name="user_password")
    @NonNull private String password;

    @Column(name="email")
    @NonNull private String email;

    //private Image avatar; TODO: Determine what datatype to store the avatar in.

    @Column(name="user_level")
    @Enumerated(EnumType.STRING)
    @NonNull private UserLevel userLevel;

    @ManyToMany(mappedBy = "users")
    private List<Board> boards;
}
