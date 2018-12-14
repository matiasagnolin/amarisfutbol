package com.amaris.futbol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.amaris.futbol.domain.Player;
import com.amaris.futbol.repository.IGenericDAO;

public class PlayerService extends GenericServiceImple<Player> {

    @Autowired
    public PlayerService(
            @Qualifier("PlayerDao") final IGenericDAO<Player, Long> genericDao) {
        setGenericDAO(genericDao);
    }
}
