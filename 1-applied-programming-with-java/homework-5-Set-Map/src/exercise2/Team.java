package exercise2;

import java.util.Map;
import java.util.TreeMap;

public class Team implements Comparable<Team> {
    private String name;
    private SportType sportType;
    private Coach coach;
    private int budget;

    private Map<Athlete, Double> registeredAthletesToTransferRate;

    public Team(String name, SportType sportType, Coach coach, int budget) throws Exception {
        if (sportType != coach.getSportType()) {
            throw new Exception("The Coach's SportType should be the same as the Team's SportType");
        }

        this.name = name;
        this.sportType = sportType;
        this.coach = coach;
        this.budget = budget;

        this.registeredAthletesToTransferRate = new TreeMap<>();
    }

    public void addAthlete(Athlete athlete, Double transferPrice) throws Exception {
        if (athlete.getSportType() != this.sportType) {
            throw new Exception("The Athlete's SportType should be the same as the Team's SportType");
        }

        this.registeredAthletesToTransferRate.put(athlete, transferPrice);
    }

    public String getName() {
        return name;
    }

    public SportType getSportType() {
        return this.sportType;
    }

    public Map<Athlete, Double> getRegisteredAthletes() {
        return this.registeredAthletesToTransferRate;
    }

    public Coach getCoach() {
        return coach;
    }

    @Override
    public int compareTo(Team team) {
        if (this.sportType == team.sportType) {
            return Double.compare(this.budget, team.budget);
        }

        return Integer.compare(this.sportType.getMainAthletesCount(), team.sportType.getMainAthletesCount());
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", sportType=" + sportType +
                ", coach=" + coach +
                ", budget=" + budget +
                '}';
    }
}
