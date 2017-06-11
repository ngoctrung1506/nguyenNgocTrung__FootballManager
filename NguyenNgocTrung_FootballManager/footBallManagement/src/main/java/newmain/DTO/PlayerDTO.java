package newmain.DTO;

import newmain.Model.Player;
import newmain.Model.Team;

/**
 * Created by Admin on 02/06/2017.
 */
public class PlayerDTO {
    private int id;
    private String name;
    private String position;
    private int goal;
    private String photo;
    private int age;
    private TeamDTO team;

    public PlayerDTO() {
    }

    public PlayerDTO(Player player) {
        this.id = player.getId();
        this.name = player.getName();
        this.position = player.getPosition();
        this.goal = player.getGoal();
        this.photo = player.getPhoto();
        this.age = player.getAge();
        this.team = new TeamDTO(player.getTeam());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public TeamDTO getTeam() {
        return team;
    }

    public void setTeam(TeamDTO team) {
        this.team = team;
    }
}
