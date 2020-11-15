package exercise2;

public class Athlete implements Comparable<Athlete> {
    private String name;
    private SportType sportType;

    public Athlete(String name, SportType sportType) {
        this.name = name;
        this.sportType = sportType;
    }

    public SportType getSportType() {
        return sportType;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Athlete athlete) {
        return this.name.compareTo(athlete.getName());
    }
}
