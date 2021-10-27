package com.revature.rit.reposistory;

import com.revature.rit.models.issues.CommentAction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentActionRepository extends CrudRepository<CommentAction, Integer> {
}
