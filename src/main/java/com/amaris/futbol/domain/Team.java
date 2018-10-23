package com.amaris.futbol.domain;

import com.amaris.futbol.interfaces.IPlayer;
import com.amaris.futbol.interfaces.ITeam;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.List;

@Getter
@Setter
@Entity
public class Team extends BaseEntity implements ITeam {

    List<IPlayer> startingPlayers;
    List<IPlayer> substitutePlayers;


    @Override
    public void addPlayer(IPlayer player) {

    }

    @Override
    public void deletePlayer(IPlayer player) {

    }
}
