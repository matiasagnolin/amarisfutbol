package com.amaris.futbol.domain;


import com.amaris.futbol.interfaces.ITeam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;



@Getter
@Setter
@Table(name = "Matches")
@Entity
@NoArgsConstructor
public class Match extends Event {

    ITeam firstTeam;

    ITeam SecondTeam;

    int firstTeamResult;

    int secondTeamResult;

}