package com.revature.rit.reposistory;

import com.revature.rit.models.boards.ListItems;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListItemsRepository extends CrudRepository<ListItems, Integer> {
}
