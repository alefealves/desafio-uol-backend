package alefea.alves.uolhostbackend.service;

import alefea.alves.uolhostbackend.infra.CodinameHandler;
import alefea.alves.uolhostbackend.model.GroupType;
import alefea.alves.uolhostbackend.model.Player;
import alefea.alves.uolhostbackend.model.dto.PlayerDTO;
import alefea.alves.uolhostbackend.repositories.PlayerRepository;
import org.hibernate.query.ParameterLabelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.PropertyPlaceholderHelper;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    @Autowired
    private CodinameHandler handler;

    public Player createPlayer(PlayerDTO dto){
        Player newPlayer = new Player(dto);
        String codiname = getCodiname(dto.groupType());
        newPlayer.setCodiname(codiname);
        return repository.save(newPlayer);
    }

    private String getCodiname(GroupType groupType){
        return handler.findCodiname(groupType);
    }


    public List<Player> getAllPlayers() {
        return repository.findAll();
    }
}
