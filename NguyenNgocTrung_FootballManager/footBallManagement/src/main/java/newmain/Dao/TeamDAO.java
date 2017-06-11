package newmain.Dao;

import newmain.Model.Team;

import java.util.List;

/**
 * Created by Admin on 10/06/2017.
 */
public interface TeamDAO {
    Team findByID(int id);
    List<Team> findAll();
    List<Team> findAllTeambyLeagueId(int id);
    void updateTeam(Team team);
    void removeTeam(int id);
    void addTeam(Team p);
}
