package newmain.Service;

import DTO.TeamDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admin on 02/06/2017.
 */
@Service
public interface TeamService
{
    public TeamDTO getTeamById(int id);

    public List<TeamDTO> findAll();
}
