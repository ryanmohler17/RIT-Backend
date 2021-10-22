package com.revature.rit.repos;

import com.revature.rit.models.boards.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
    Optional<Board> findByCreatorId(Integer creator);
}
