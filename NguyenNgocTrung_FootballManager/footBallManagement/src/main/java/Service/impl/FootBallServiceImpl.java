package Service.impl;


import DTO.TeamDTO;
import DTO.TeamListDTO;
import Dao.TeamDAO;
import Model.Team;
import Service.FootBallService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Admin on 02/06/2017.
 */
public class FootBallServiceImpl implements FootBallService{

    @Autowired
    TeamDAO teamDAO;

    public TeamDTO getTeamById(int id) {
        Team team = teamDAO.findByID(id);
        return new TeamDTO(team);
    }

    public TeamListDTO findAll() {
        return null;
    }
}
