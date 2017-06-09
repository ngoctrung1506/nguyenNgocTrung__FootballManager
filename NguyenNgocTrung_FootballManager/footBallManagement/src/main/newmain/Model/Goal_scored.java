package Model;

import javax.persistence.*;

/**
 * Created by Admin on 02/06/2017.
 */
@Entity
@Table(name = "goal_scrored")
public class Goal_scored {
    private int id;
    private int time;
    private Players player;
    private Match match;

    public Goal_scored() {
    }

    public Goal_scored(int id, int time, Players player, Match match) {
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
    public Players getPlayer() {
        return player;
    }

    public void setPlayer(Players player) {
        this.player = player;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
}
