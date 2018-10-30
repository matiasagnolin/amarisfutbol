package com.amaris.futbol.Service;


import com.amaris.futbol.domain.Player;
import com.amaris.futbol.repository.IGenericDAO;
import com.amaris.futbol.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class PlayerService extends GenericServiceImple<Player> {


   private PlayerRepository consultantRepository;

    @Autowired
    public PlayerService(
            @Qualifier("PlayerRepository") IGenericDAO<Player, Long> genericDao) {
        super(genericDao);
        this.consultantRepository =  (PlayerRepository) genericDao;
    }
}
