package com.revature.rit.reposistory;

import com.revature.rit.models.boards.BoardList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardListRepository extends CrudRepository<BoardList, Integer> {
}
