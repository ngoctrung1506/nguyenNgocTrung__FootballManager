package Service;

import DTO.PersonDTO;
import DTO.PersonListDTO;
import DTO.TeamDTO;
import DTO.TeamListDTO;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 02/06/2017.
 */
@Service
public interface  FootBallService
{
    public TeamDTO getTeamById(int id);

    public TeamListDTO findAll();
}
