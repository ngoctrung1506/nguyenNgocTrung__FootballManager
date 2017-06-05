package Model;

import javax.persistence.*;

/**
 * Created by Admin on 02/06/2017.
 */
@Entity
@Table(name = "Player_match")
public class Player_match {
    private int id;
    private Match match;
    private Players player;
    private int min_played;
    private int yellow_card;
    private int red_card;

    public Player_match() {
    }

    public Player_match(int id, Match match, Players player, int min_played, int yellow_card, int red_card) {
        this.id = id;
        this.match = match;
        this.player = player;

        this.min_played = min_played;
        this.yellow_card = yellow_card;
        this.red_card = red_card;
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

    @ManyToOne(cascade = CascadeType.ALL)
    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Players getPlayer() {
        return player;
    }

    public void setPlayer(Players player) {
        this.player = player;
    }

    @Column(name = "min_played")
    public int getMin_played() {
        return min_played;
    }

    public void setMin_played(int min_played) {
        this.min_played = min_played;
    }

    @Column(name = "yellow_card")
    public int getYellow_card() {
        return yellow_card;
    }

    public void setYellow_card(int yellow_card) {
        this.yellow_card = yellow_card;
    }

    @Column(name = "red_card")
    public int getRed_card() {
        return red_card;
    }

    public void setRed_card(int red_card) {
        this.red_card = red_card;
    }
}
