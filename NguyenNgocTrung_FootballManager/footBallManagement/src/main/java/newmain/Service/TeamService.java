package newmain.Service;

import newmain.DTO.TeamDTO;
import newmain.Model.Team;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Admin on 10/06/2017.
 */
public interface TeamService {
     TeamDTO getTeamById(int id);
     List<TeamDTO> findAll();
     List<TeamDTO> findAllTeambyLeagueId(int id);
     void updateTeam(Team team);
     void removeTeam(int id);
     void addTeam(Team p);
}
