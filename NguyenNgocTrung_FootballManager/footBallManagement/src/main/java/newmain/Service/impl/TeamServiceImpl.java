package newmain.Service.Impl;

import newmain.DTO.TeamDTO;
import newmain.Dao.TeamDAO;
import newmain.Model.Team;
import newmain.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 10/06/2017.
 */
@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamDAO teamDAO;

    public void setTeamDAO(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    @Override
    @Transactional
    public TeamDTO getTeamById(int id) {
        Team team = teamDAO.findByID(id);
        return new TeamDTO(team);
    }

    @Override
    @Transactional
    public List<TeamDTO> findAll()
    {
        List<TeamDTO> teamDTOList = new ArrayList<TeamDTO>();
        List<Team> teams= teamDAO.findAll();
        for(Team team : teams){
            TeamDTO teamDTO = new TeamDTO(team);
            teamDTOList.add(teamDTO);
        }
        return teamDTOList;
    }


    @Override
    @Transactional
    public List<TeamDTO> findAllTeambyLeagueId(int id)
    {
        List<TeamDTO> teamDTOList = new ArrayList<TeamDTO>();
        List<Team> teams= teamDAO.findAllTeambyLeagueId(id);
        for(Team team : teams){
            TeamDTO teamDTO = new TeamDTO(team);
            teamDTOList.add(teamDTO);
        }
        return teamDTOList;
    }

    @Override
    @Transactional
    public void updateTeam(Team team) {
        this.teamDAO.updateTeam(team);
    }


    @Override
    @Transactional
    public void removeTeam(int id) {
        this.teamDAO.removeTeam(id);
    }

    @Override
    @Transactional
    public void addTeam(Team p) {
        this.teamDAO.addTeam(p);
    }



}
