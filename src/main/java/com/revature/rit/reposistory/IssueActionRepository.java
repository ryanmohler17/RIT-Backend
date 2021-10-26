package com.revature.rit.reposistory;

import com.revature.rit.models.issues.IssueAction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueActionRepository extends CrudRepository<IssueAction, Integer> {
}
