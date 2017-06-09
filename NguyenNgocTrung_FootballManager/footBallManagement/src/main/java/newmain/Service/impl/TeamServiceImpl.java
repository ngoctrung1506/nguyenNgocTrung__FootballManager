package newmain.Service.impl;


import DTO.TeamDTO;
import Dao.TeamDAO;
import Service.TeamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Admin on 02/06/2017.
 */
@Service
public class TeamServiceImpl implements TeamService {

    private TeamDAO teamDAO;

    public void setTeamDAO(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    @Override
    @Transactional
    public TeamDTO getTeamById(int id) {
        TeamDTO team = teamDAO.findByID(id);
        return new TeamDTO(team);
    }

    @Override
    @Transactional
    public List<TeamDTO> findAll()
    {
        return this.teamDAO.findAll();
    }
}
