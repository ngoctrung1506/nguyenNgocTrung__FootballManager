package newmain.Dao;

import newmain.Model.League;

import java.util.List;

/**
 * Created by Admin on 11/06/2017.
 */
public interface LeagueDAO {
    League findByID(int id);
    List<League> findAll();
    void updateLeague(League League);
    void removeLeague(int id);
    void addLeague(League p);
}
