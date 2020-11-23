package exercise2;

public class Coach {
    private String name;
    private int experienceYears;
    private SportType sportType;

    public Coach(String name, int experienceYears, SportType sportType) {
        this.name = name;
        this.experienceYears = experienceYears;
        this.sportType = sportType;
    }

    public SportType getSportType() {
        return sportType;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "name='" + name + '\'' +
                ", experienceYears=" + experienceYears +
                ", sportType=" + sportType +
                '}';
    }
}
