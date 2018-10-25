package com.amaris.futbol.repository;

import com.amaris.futbol.domain.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ITeamRepository extends CrudRepository<Team,Long> {
    @Override
    Optional<Team> findById(Long aLong);
}
