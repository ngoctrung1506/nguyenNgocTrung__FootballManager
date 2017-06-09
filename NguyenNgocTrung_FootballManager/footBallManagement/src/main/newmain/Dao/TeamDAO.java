package Dao;

import DTO.TeamDTO;
import Model.Team;

import java.util.List;

/**
 * Created by Admin on 02/06/2017.
 */
public interface TeamDAO {
    TeamDTO findByID(int id);
    List<TeamDTO> findAll();
}
