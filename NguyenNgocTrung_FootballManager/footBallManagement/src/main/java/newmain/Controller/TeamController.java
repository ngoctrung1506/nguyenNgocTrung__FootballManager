package newmain.Controller;

import DTO.TeamDTO;
import Service.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Admin on 05/06/2017.
 */
@Controller
public class TeamController {
    private TeamService teamService;

    @Autowired(required=true)
//    @Qualifier(value="teamService")

    public void setPersonService(@Qualifier(value="teamService") TeamService teamService){
        this.teamService = teamService;
    }

    @RequestMapping(value = "/teams", method = RequestMethod.GET)
    public String listPersons(Model model) {
        model.addAttribute("team", new TeamDTO());
        model.addAttribute("listTeams", this.teamService.findAll());
        return "team";
    }
    @RequestMapping("/index")
    public String home(){
        return "index";
    }


}
