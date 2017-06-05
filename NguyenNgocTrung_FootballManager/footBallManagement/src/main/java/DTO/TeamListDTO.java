package DTO;

import Model.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 02/06/2017.
 */
public class TeamListDTO {
    private List<TeamDTO> teamDTOList = new ArrayList<TeamDTO>();

    public List<TeamDTO> getPersonDTOList()
    {
        return teamDTOList;
    }

    public void setPersonDTOList(List<PersonDTO> personDTOList)
    {
        this.teamDTOList = teamDTOList;
    }

}
