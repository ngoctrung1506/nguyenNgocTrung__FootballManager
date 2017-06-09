package newmain.DTO;

import DTO.LeagueDTO;
import Model.Team;

/**
 * Created by Admin on 02/06/2017.
 */
public class TeamDTO {

        private int id;
        private String name;
        private int numberOfWin;
        private int numberOfLost;
        private int numberOfDraw;
        private int score;
        private String logo;
        private LeagueDTO league;

        public TeamDTO() {
        }

        public TeamDTO(int id, String name, int numberOfWin, int numberOfLost, int numberOfDraw, int score, String logo, LeagueDTO league) {
            this.id = id;
            this.name = name;
            this.numberOfWin = numberOfWin;
            this.numberOfLost = numberOfLost;
            this.numberOfDraw = numberOfDraw;
            this.score = score;
            this.logo = logo;
            this.league = league;
        }

    public TeamDTO(TeamDTO teamDTO) {
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

        public int getNumberOfWin() {
            return numberOfWin;
        }

        public void setNumberOfWin(int numberOfWin) {
            this.numberOfWin = numberOfWin;
        }

        public int getNumberOfLost() {
            return numberOfLost;
        }

        public void setNumberOfLost(int numberOfLost) {
            this.numberOfLost = numberOfLost;
        }

        public int getNumberOfDraw() {
            return numberOfDraw;
        }

        public void setNumberOfDraw(int numberOfDraw) {
            this.numberOfDraw = numberOfDraw;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public LeagueDTO getLeague() {
            return league;
        }

        public void setLeague(LeagueDTO league) {
            this.league = league;
        }
    }


