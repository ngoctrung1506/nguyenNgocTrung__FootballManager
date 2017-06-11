package newmain.Controller;

import newmain.DTO.PlayerDTO;
import newmain.Model.Player;
import newmain.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Admin on 12/06/2017.
 */
@Controller
public class PlayerController {
    private PlayerService playerService;

    @Autowired(required=true)
    @Qualifier(value="playerService")
    public void setPersonService(PlayerService playerService) {
        this.playerService = playerService;
    }



    @RequestMapping(value = "/players", method = RequestMethod.GET)
    public String listPlayer(Model model) {
        model.addAttribute("player", new PlayerDTO());
        model.addAttribute("listPlayers", this.playerService.findAll());
        return "player";
    }

    @RequestMapping("/remove/player/{id}")
    public String removePlayer(@PathVariable("id") int id) {
        this.playerService.removePlayer(id);
        return "redirect:/players";
    }

    @RequestMapping("/edit/player/{id}")
    public String editPlayer(@PathVariable("id") int id, Model model) {
        model.addAttribute("player", this.playerService.getPlayerById(id));
        model.addAttribute("listPlayers", this.playerService.findAll());
        return "player";
    }

    @RequestMapping("/findPlayer/{id}")
    public String findPlayer(@PathVariable("id") int id, Model model) {
        model.addAttribute("player", new PlayerDTO());
        model.addAttribute("listPlayers", this.playerService.findAllPlayerbyLeagueId(id));
        return "player";
    }

    @RequestMapping(value = "/player/add", method = RequestMethod.POST)
    public String addPlayer(@ModelAttribute("player") Player player) {
        if (player.getId() == 0) {
            // new player, add it
            this.playerService.addPlayer(player);
        } else {
            // existing player, call update
            this.playerService.updatePlayer(player);
        }
        return "redirect:/players";
    }


    
}
