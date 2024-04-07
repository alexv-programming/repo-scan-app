package com.exercise.reposcanms.repositories;

import com.exercise.reposcanms.model.Repo;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryRepo extends CrudRepository<Repo, Long> {
}
