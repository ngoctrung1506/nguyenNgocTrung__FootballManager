package newmain.Service;

import newmain.DTO.LeagueDTO;
import newmain.Model.League;

import java.util.List;

/**
 * Created by Admin on 11/06/2017.
 */
public interface LeagueService {
    public LeagueDTO getLeagueById(int id);
    public List<LeagueDTO> findAll();
    void updateLeague(League League);
    void removeLeague(int id);
    void addLeague(League p);
}
