package newmain.Model;

import javax.persistence.*;

/**
 * Created by Admin on 02/06/2017.
 */
@Entity
@Table(name = "team")
public class Team {
    private int id;
    private String name;
    private int numberOfWin;
    private int numberOfLost;
    private int numberOfDraw;
    private int score;
    private String logo;
    private League league;

    public Team() {
    }

    public Team(int id, String name, int numberOfWin, int numberOfLost, int numberOfDraw, int score, String logo, League league) {
        this.id = id;
        this.name = name;
        this.numberOfWin = numberOfWin;
        this.numberOfLost = numberOfLost;
        this.numberOfDraw = numberOfDraw;
        this.score = score;
        this.logo = logo;
        this.league = league;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "numberofwin")
    public int getNumberOfWin() {
        return numberOfWin;
    }

    public void setNumberOfWin(int numberOfWin) {
        this.numberOfWin = numberOfWin;
    }

    @Column(name = "numberoflost")
    public int getNumberOfLost() {
        return numberOfLost;
    }

    public void setNumberOfLost(int numberOfLost) {
        this.numberOfLost = numberOfLost;
    }

    @Column(name = "numberofdraw")
    public int getNumberOfDraw() {
        return numberOfDraw;
    }

    public void setNumberOfDraw(int numberOfDraw) {
        this.numberOfDraw = numberOfDraw;
    }

    @Column(name = "score")
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Column(name = "logo")
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "leage_id")
    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }
}
