package newmain.DTO;

import newmain.Model.League;

/**
 * Created by Admin on 02/06/2017.
 */
public class LeagueDTO {

        private int id;
        private String  name;
        private String  logo;
        private int prize;

        public LeagueDTO() {
        }

        public LeagueDTO(League league) {
            this.id = league.getId();
            this.name = league.getName();
            this.logo = league.getLogo();
            this.prize = league.getPrize();
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

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public int getPrize() {
            return prize;
        }

        public void setPrize(int prize) {
            this.prize = prize;
        }

        
    }


