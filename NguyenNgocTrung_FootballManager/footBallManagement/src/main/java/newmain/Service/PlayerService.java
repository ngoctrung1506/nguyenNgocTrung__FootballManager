package newmain.Service;

import newmain.DTO.PlayerDTO;
import newmain.Model.Player;

import java.util.List;

/**
 * Created by Admin on 12/06/2017.
 */
public interface PlayerService {
    PlayerDTO getPlayerById(int id);
    List<PlayerDTO> findAll();
    List<PlayerDTO> findAllPlayerbyLeagueId(int id);
    void updatePlayer(Player team);
    void removePlayer(int id);
    void addPlayer(Player p);
}
