package newmain.DTO;

import newmain.Model.League;
import newmain.Model.Team;

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


    public TeamDTO(Team team) {
        League leagueModel = team.getLeague();
        LeagueDTO leagueDTO = new LeagueDTO(leagueModel);
        this.id = team.getId();
        this.name = team.getName();
        this.numberOfWin = team.getNumberOfWin();
        this.numberOfLost = team.getNumberOfLost();
        this.numberOfDraw = team.getNumberOfDraw();
        this.score = team.getScore();
        this.logo = team.getLogo();
        this.league = leagueDTO;
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


