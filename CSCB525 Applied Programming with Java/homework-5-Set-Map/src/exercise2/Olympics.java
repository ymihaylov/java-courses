package exercise2;

import java.time.LocalDate;
import java.util.*;

public class Olympics {
    private LocalDate date;
    private String location;

    private Map<Team, Set<Athlete>> mainAthletesByTeam;
    private Map<Team, Set<Athlete>> reserveAthletesByTeam;

    public Olympics(LocalDate date, String location) {
        this.date = date;
        this.location = location;

        this.mainAthletesByTeam = new HashMap<>();
        this.reserveAthletesByTeam = new HashMap<>();
    }

    public void addTeam(Team team) {
        this.mainAthletesByTeam.put(team, new TreeSet<Athlete>());
        this.reserveAthletesByTeam.put(team, new TreeSet<Athlete>());
    }

    public void addMainAthlete(Team team, Athlete athlete) {
        if (!this.mainAthletesByTeam.containsKey(team)) {
            this.addTeam(team);
        }

        if (this.mainAthletesByTeam.get(team).size() >= team.getSportType().getMainAthletesCount()) {
            System.out.println("Team quota for main is full.");
            return;
        }

        this.mainAthletesByTeam.get(team).add(athlete);
    }

    public void addReserveAthlete(Team team, Athlete athlete) {
        if (!this.reserveAthletesByTeam.containsKey(team)) {
            this.addTeam(team);
        }

        if (this.reserveAthletesByTeam.get(team).size() >= team.getSportType().getReserveAthletesCount()) {
            System.out.println("Team quota for reserve athletes is full.");
            return;
        }

        this.reserveAthletesByTeam.get(team).add(athlete);
    }

    public void addAthlete(Team team, Athlete athlete, boolean isMain) {
        if (isMain) {
            this.addMainAthlete(team, athlete);
            return;
        }

        this.addReserveAthlete(team, athlete);
    }

    public void removeAthlete(Team team, Athlete athlete) {
        if (this.mainAthletesByTeam.get(team).remove(athlete)) {
            Athlete nextReserve = this.reserveAthletesByTeam.get(team).iterator().next();
            this.mainAthletesByTeam.get(team).add(nextReserve);
            this.reserveAthletesByTeam.get(team).remove(nextReserve);
        }

        this.reserveAthletesByTeam.get(team).remove(athlete);
    }

    public void printTeams() {
        for (Team team : this.mainAthletesByTeam.keySet()) {
            System.out.println(team);
            System.out.println("Main athletes from team:");
            this.mainAthletesByTeam.get(team).forEach((Athlete athlete) -> {
                System.out.println(athlete);
            });

            System.out.println("Reserve athletes from team:");
            this.reserveAthletesByTeam.get(team).forEach((Athlete athlete) -> {
                System.out.println(athlete);
            });
            System.out.println("\n--------------\n");
        }
    }

    public Set<Athlete> getMainAthletesByTeam(Team team) {
        return this.mainAthletesByTeam.get(team);
    }

    public void removeTeam(Team team) {
        this.mainAthletesByTeam.remove(team);
        this.reserveAthletesByTeam.remove(team);
    }

    public Coach getMostExperiencedCoach() throws Exception {
        List<Team> teams = new ArrayList<>(this.mainAthletesByTeam.keySet());

        if (teams.isEmpty()) {
            throw new Exception("There's no registered teams in this olympics yet.");
        }

        teams.sort(new Comparator<Team>() {
            @Override
            public int compare(Team team1, Team team2) {
                return Integer.compare(team1.getCoach().getExperienceYears(), team2.getCoach().getExperienceYears());
            }
        });

        return teams.get(teams.size() - 1).getCoach();
    }

    // It's hacky and I know it (music)
    // https://i.kym-cdn.com/entries/icons/original/000/021/807/ig9OoyenpxqdCQyABmOQBZDI0duHk2QZZmWg2Hxd4ro.jpg
    public Map<Team, Set<Athlete>> getSortedMainTeams() {
        TreeMap<Team, Set<Athlete>> sorted = new TreeMap<>(this.mainAthletesByTeam);
        return sorted;
    }

    public Map<Team, Set<Athlete>> getSortedReserveTeams() {
        TreeMap<Team, Set<Athlete>> sorted = new TreeMap<>(this.reserveAthletesByTeam);
        return sorted;
    }
}
