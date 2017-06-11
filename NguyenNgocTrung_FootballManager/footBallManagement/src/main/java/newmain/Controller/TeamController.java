package newmain.Controller;

import newmain.DTO.TeamDTO;
import newmain.Model.League;
import newmain.Model.Team;
import newmain.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 11/06/2017.
 */
@Controller
public class TeamController {
    private TeamService teamService;

    @Autowired(required=true)
    @Qualifier(value = "teamService")
    public void setPersonService(TeamService teamService) {
        this.teamService = teamService;
    }


    @RequestMapping(value = "/teams", method = RequestMethod.GET)
    public String listTeam(Model model) {
        model.addAttribute("team", new TeamDTO());
        model.addAttribute("listTeams", this.teamService.findAll());
        List<TeamDTO> teams = this.teamService.findAll();
        System.out.print(teams.get(0).getLeague().getName());
        return "team";
    }

    @RequestMapping("/remove/team/{id}")
    public String removeTeam(@PathVariable("id") int id) {
        this.teamService.removeTeam(id);
        return "redirect:/teams";
    }

    @RequestMapping("/edit/team/{id}")
    public String editTeam(@PathVariable("id") int id, Model model) {
        model.addAttribute("team", this.teamService.getTeamById(id));
        model.addAttribute("listTeams", this.teamService.findAll());
        return "team";
    }

    @RequestMapping("/findTeam/{id}")
    public String findTeam(@PathVariable("id") int id, Model model) {
        model.addAttribute("team", new TeamDTO());
        model.addAttribute("listTeams", this.teamService.findAllTeambyLeagueId(id));
        return "team";
    }

    @RequestMapping(value = "/team/add", method = RequestMethod.POST)
    public String addTeam(@ModelAttribute("team") Team team) {
        if (team.getId() == 0) {
            // new team, add it
            this.teamService.addTeam(team);
        } else {
            // existing team, call update
            this.teamService.updateTeam(team);
        }
        return "redirect:/teams";
    }

    @RequestMapping("/viewPlayers/{id}")
    public String viewJoinedTeam(@PathVariable("id") int id, Model model) {
        return "redirect:/findPlayer/{id}";
    }
}
