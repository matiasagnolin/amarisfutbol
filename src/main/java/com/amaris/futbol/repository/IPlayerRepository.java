package com.amaris.futbol.repository;

import com.amaris.futbol.domain.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IPlayerRepository<Player,Long> extends CrudRepository<Player, Long> {
    @Override
    Optional<Player> findById(Long aLong);
}
