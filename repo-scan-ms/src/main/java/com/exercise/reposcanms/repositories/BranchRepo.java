package com.exercise.reposcanms.repositories;

import com.exercise.reposcanms.model.Branch;
import org.springframework.data.repository.CrudRepository;

public interface BranchRepo extends CrudRepository<Branch, Long> {
}
