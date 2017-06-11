package newmain.Service.Impl;

import newmain.DTO.LeagueDTO;
import newmain.Dao.LeagueDAO;
import newmain.Model.League;
import newmain.Service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 11/06/2017.
 */
@Service
public class LeagueServiceImpl implements LeagueService {

    @Autowired
    private LeagueDAO leagueDAO;

    public void setLeagueDAO(LeagueDAO leagueDAO) {
        this.leagueDAO = leagueDAO;
    }

    @Override
    @Transactional
    public LeagueDTO getLeagueById(int id) {
        League league = leagueDAO.findByID(id);
        return new LeagueDTO(league);
    }

    @Override
    @Transactional
    public List<LeagueDTO> findAll()
    {
        List<LeagueDTO> leagueDTOList = new ArrayList<LeagueDTO>();
        List<League> leagues= leagueDAO.findAll();
        for(League league : leagues){
            LeagueDTO leagueDTO = new LeagueDTO(league);
            leagueDTOList.add(leagueDTO);
        }
        return leagueDTOList;
    }

    @Override
    @Transactional
    public void updateLeague(League League) {
        this.leagueDAO.updateLeague(League);
    }


    @Override
    @Transactional
    public void removeLeague(int id) {
        this.leagueDAO.removeLeague(id);
    }

    @Override
    @Transactional
    public void addLeague(League p) {
        this.leagueDAO.addLeague(p);
    }


}
