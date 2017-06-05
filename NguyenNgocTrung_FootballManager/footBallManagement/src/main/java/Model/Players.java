package Model;

import javax.persistence.*;

/**
 * Created by Admin on 02/06/2017.
 */
@Entity
@javax.persistence.Table(name = "player")
public class Players {
    private int id;
    private String name;
    private String position;
    private int goal;
    private String photo;
    private int age;
    private Team team;

    public Players() {
    }

    public Players(int id, String name, String position, int goal, String photo, int age, Team team) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.goal = goal;
        this.photo = photo;
        this.age = age;
        this.team = team;
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

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "POSITION")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Column(name = "GOAL")
    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    @Column(name = "PHOTO")
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Column(name = "AGE")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
