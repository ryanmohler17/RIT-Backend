package com.revature.rit.reposistory;

import com.revature.rit.models.issues.Issue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends CrudRepository<Issue, Integer> {
}
