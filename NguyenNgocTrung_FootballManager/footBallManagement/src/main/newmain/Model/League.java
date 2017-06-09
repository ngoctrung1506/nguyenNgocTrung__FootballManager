package Model;

import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Admin on 02/06/2017.
 */
@Entity
@javax.persistence.Table(name = "league")
public class League {
    private int id;
    private String  name;
    private String  logo;
    private int prize;

    public League() {
    }

    public League(int id, String name, String logo, int prize) {
        this.id = id;
        this.name = name;
        this.logo = logo;
        this.prize = prize;
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

    @Column(name = "LOGO")
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Column(name = "PRIZE")
    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }
}
