package com.revature.rit.reposistory;

import com.revature.rit.models.boards.Board;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardRepository extends CrudRepository<Board, Integer> {
    Optional<Board> findByCreatorId(Integer creatorId);
}
