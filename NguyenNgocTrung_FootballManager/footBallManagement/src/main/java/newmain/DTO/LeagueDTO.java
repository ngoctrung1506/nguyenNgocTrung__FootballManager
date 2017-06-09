package newmain.DTO;

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

        public LeagueDTO(int id, String name, String logo, int prize) {
            this.id = id;
            this.name = name;
            this.logo = logo;
            this.prize = prize;
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


