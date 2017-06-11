package newmain.Dao;

import newmain.Model.Player;

import java.util.List;

/**
 * Created by Admin on 12/06/2017.
 */
public interface PlayerDAO {
    Player findByID(int id);
    List<Player> findAll();
    List<Player> findAllPlayerbyLeagueId(int id);
    void updatePlayer(Player team);
    void removePlayer(int id);
    void addPlayer(Player p);
}
