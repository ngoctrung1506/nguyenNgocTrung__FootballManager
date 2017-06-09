package newmain.Model;

import Model.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Admin on 02/06/2017.
 */
@Entity
@Table(name = "match")
public class Match {
    private int id;
    private int team1_score;
    private int team2_score;
    private Date date;
    Model.Team team1;
    Model.Team team2;

    public Match() {
    }

    public Match(int id, int team1_score, int team2_score, Date date, Model.Team team1, Model.Team team2) {
        this.id = id;
        this.team1_score = team1_score;
        this.team2_score = team2_score;
        this.date = date;
        this.team1 = team1;
        this.team2 = team2;
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

    @Column(name = "TEAM1_SCORE")
    public int getTeam1_score() {
        return team1_score;
    }

    public void setTeam1_score(int team1_score) {
        this.team1_score = team1_score;
    }

    @Column(name = "TEAM2_SCORE")
    public int getTeam2_score() {
        return team2_score;
    }

    public void setTeam2_score(int team2_score) {
        this.team2_score = team2_score;
    }

    @Column(name = "DATE")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Model.Team getTeam1() {
        return team1;
    }

    public void setTeam1(Model.Team team1) {
        this.team1 = team1;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Model.Team getTeam2() {
        return team2;
    }

    public void setTeam2(Model.Team team2) {
        this.team2 = team2;
    }
}
