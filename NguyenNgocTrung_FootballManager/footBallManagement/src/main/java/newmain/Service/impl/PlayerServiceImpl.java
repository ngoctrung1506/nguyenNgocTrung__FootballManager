package newmain.Service.Impl;

import newmain.DTO.PlayerDTO;
import newmain.Dao.PlayerDAO;
import newmain.Model.Player;
import newmain.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 12/06/2017.
 */
@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerDAO playerDAO;

    public void setPlayerDAO(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    @Override
    @Transactional
    public PlayerDTO getPlayerById(int id) {
        Player player = playerDAO.findByID(id);
        return new PlayerDTO(player);
    }

    @Override
    @Transactional
    public List<PlayerDTO> findAll()
    {
        List<PlayerDTO> playerDTOList = new ArrayList<PlayerDTO>();
        List<Player> players= playerDAO.findAll();
        for(Player player : players){
            PlayerDTO playerDTO = new PlayerDTO(player);
            playerDTOList.add(playerDTO);
        }
        return playerDTOList;
    }


    @Override
    @Transactional
    public List<PlayerDTO> findAllPlayerbyLeagueId(int id)
    {
        List<PlayerDTO> playerDTOList = new ArrayList<PlayerDTO>();
        List<Player> players= playerDAO.findAllPlayerbyLeagueId(id);
        for(Player player : players){
            PlayerDTO playerDTO = new PlayerDTO(player);
            playerDTOList.add(playerDTO);
        }
        return playerDTOList;
    }

    @Override
    @Transactional
    public void updatePlayer(Player player) {
        this.playerDAO.updatePlayer(player);
    }


    @Override
    @Transactional
    public void removePlayer(int id) {
        this.playerDAO.removePlayer(id);
    }

    @Override
    @Transactional
    public void addPlayer(Player p) {
        this.playerDAO.addPlayer(p);
    }


}
