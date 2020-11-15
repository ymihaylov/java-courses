import exercise1.PlasticGoods;
import exercise1.PlasticGoodsManufacturer;
import exercise2.*;

import java.time.LocalDate;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Exercise 1
        {
            PlasticGoodsManufacturer plasticGoodsManufacturer = new PlasticGoodsManufacturer("Lorelli");
            plasticGoodsManufacturer
                .addSupportedPlasticGoods(new PlasticGoods("Toy Car", 10.00))
                .addSupportedPlasticGoods(new PlasticGoods("Doll Toy", 15.00))
                .addSupportedPlasticGoods(new PlasticGoods("Mini house toy", 20.00))
                .addSupportedPlasticGoods(new PlasticGoods("Plastic book", 12.00))
                .addSupportedPlasticGoods(new PlasticGoods("Plastic fish toy", 6.00));

            System.out.println("Closest to average:");
            System.out.println(plasticGoodsManufacturer.closestToAverage());

            System.out.println("Below average plastic goods:");
            System.out.println(plasticGoodsManufacturer.belowAveragePrice());

            System.out.println("Above average plastic goods:");
            System.out.println(plasticGoodsManufacturer.aboveAveragePrice());
            System.out.println("\n######\n");
        }

        // Exercise 2
        {
            try {
                Team footballTeam1 = new Team("Football Team 1", SportType.FOOTBALL, new Coach("Coach Football Team 1", 30, SportType.FOOTBALL), 1000);
                Team footballTeam2 = new Team("Football Team 2", SportType.FOOTBALL, new Coach("Coach Football Team 2", 20, SportType.FOOTBALL), 1500);
                Team footballTeam3 = new Team("Football Team 3", SportType.FOOTBALL, new Coach("Coach Football Team 3", 10, SportType.FOOTBALL), 2500);

                Team basketballTeam1 = new Team("Basketball Team 1", SportType.BASKETBALL, new Coach("Coach Basketball Team 1", 30, SportType.BASKETBALL), 500);
                Team basketballTeam2 = new Team("Basketball Team 2", SportType.BASKETBALL, new Coach("Coach Basketball Team 2", 20, SportType.BASKETBALL), 1100);
                Team basketballTeam3 = new Team("Basketball Team 3", SportType.BASKETBALL, new Coach("Coach Basketball Team 3", 40, SportType.BASKETBALL), 2000);

                Team volleballTeam1 = new Team("Volleyball Team 1", SportType.VOLLEYBALL, new Coach("Coach Volleyball Team 1", 30, SportType.VOLLEYBALL), 1500);
                Team volleballTeam2 = new Team("Volleyball Team 2", SportType.VOLLEYBALL, new Coach("Coach Volleyball Team 2", 20, SportType.VOLLEYBALL), 1200);
                Team volleballTeam3 = new Team("Volleyball Team 3", SportType.VOLLEYBALL, new Coach("Coach Volleyball Team 3", 40, SportType.VOLLEYBALL), 1060);

                Olympics olympics = new Olympics(LocalDate.of(2021 , 6 , 12), "Trinidad and Tobago");

                // a) Add team to olympics
                olympics.addTeam(footballTeam1);
                olympics.addTeam(footballTeam2);
                olympics.addTeam(footballTeam3);

                olympics.addTeam(basketballTeam1);
                olympics.addTeam(basketballTeam2);
                olympics.addTeam(basketballTeam3);

                olympics.addTeam(volleballTeam1);
                olympics.addTeam(volleballTeam2);
                olympics.addTeam(volleballTeam3);

                // b) Add athletes to olympics
                Main.seedAthletes(olympics, footballTeam1);
                Main.seedAthletes(olympics, footballTeam2);
                Main.seedAthletes(olympics, footballTeam3);

                Main.seedAthletes(olympics, basketballTeam1);
                Main.seedAthletes(olympics, basketballTeam2);
                Main.seedAthletes(olympics, basketballTeam3);

                Main.seedAthletes(olympics, volleballTeam1);
                Main.seedAthletes(olympics, volleballTeam2);
                Main.seedAthletes(olympics, volleballTeam3);

                // c) Remove team
                // olympics.removeTeam(footballTeam2);

                // d) Remove athlete from team in the olympics
                olympics.removeAthlete(footballTeam1, footballTeam1.getRegisteredAthletes().keySet().iterator().next());

                // e) Print teams
                olympics.printTeams();

                // f) Show most experienced coach
                System.out.println("Most experienced coach: " + olympics.getMostExperiencedCoach());

                // g) Get sorted teams
                olympics.getSortedMainTeams().forEach((team, athletes) -> System.out.println(team));
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }
    }

    private static void seedAthletes(Olympics olympics, Team team) {

        for (int i = 0; i < team.getSportType().getTotalAthletesCount(); i++) {
            try {
                Athlete athlete = new Athlete(team.getName()  + " Athlete " + i, team.getSportType());
                team.addAthlete(athlete, new Random().nextDouble());
                boolean isMain = olympics.getMainAthletesByTeam(team).size() < team.getSportType().getMainAthletesCount();
                olympics.addAthlete(team, athlete, isMain);
            } catch (Exception e) {}
        }
    }
}
