package newmain.Controller;

import newmain.DTO.LeagueDTO;
import newmain.Model.League;
import newmain.Service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Admin on 11/06/2017.
 */
@Controller
public class LeagueController {
    private LeagueService leagueService;

    @Autowired(required=true)
    @Qualifier(value="leagueService")
    public void setPersonService(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @RequestMapping(value = "/leagues", method = RequestMethod.GET)
    public String listPersons(Model model) {
        model.addAttribute("league", new LeagueDTO());
        model.addAttribute("listLeagues", this.leagueService.findAll());
        return "league";
    }


    @RequestMapping("/remove/league/{id}")
    public String removeLeague(@PathVariable("id") int id) {
        this.leagueService.removeLeague(id);
        return "redirect:/leagues";
    }

    @RequestMapping("/edit/league/{id}")
    public String editLeague(@PathVariable("id") int id, Model model) {
        model.addAttribute("league", this.leagueService.getLeagueById(id));
        model.addAttribute("listLeagues", this.leagueService.findAll());
        return "league";
    }

    @RequestMapping("/viewJoinedTeam/{id}")
    public String viewJoinedTeam(@PathVariable("id") int id, Model model) {
        return "redirect:/findTeam/{id}";
    }

    @RequestMapping(value = "/league/add", method = RequestMethod.POST)
    public String addLeague(@ModelAttribute("league") League league) {

        if (league.getId() == 0) {
            // new league, add it
            this.leagueService.addLeague(league);
        } else {
            // existing league, call update
            this.leagueService.updateLeague(league);
        }
        return "redirect:/leagues";
    }

}
