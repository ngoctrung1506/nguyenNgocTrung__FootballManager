package newmain.Model;

import Model.*;
import Model.Match;

import javax.persistence.*;

/**
 * Created by Admin on 02/06/2017.
 */
@Entity
@Table(name = "goal_scrored")
public class Goal_scored {
    private int id;
    private int time;
    private Model.Players player;
    private Model.Match match;

    public Goal_scored() {
    }

    public Goal_scored(int id, int time, Model.Players player, Model.Match match) {
        this.id = id;
        this.time = time;
        this.player = player;
        this.match = match;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "time")
    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Model.Players getPlayer() {
        return player;
    }

    public void setPlayer(Model.Players player) {
        this.player = player;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Model.Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
}
