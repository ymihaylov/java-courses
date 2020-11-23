import java.util.*;
import java.util.stream.Collectors;

public class TravelAgency {
    private String name;
    private int numberOfGifts;

    private Map<Trip, Employee> tripsToEmployees;
    private Set<Customer> raffleParticipants;

    public TravelAgency(String name, int numberOfGifts) {
        this.name = name;
        this.numberOfGifts = numberOfGifts;
        this.tripsToEmployees = new HashMap<>();
        this.raffleParticipants = new HashSet<>();
    }

    public void addTrip(Trip trip, Employee employee) {
        this.tripsToEmployees.put(trip, employee);
        this.raffleParticipants.addAll(trip.getCustomers());
    }

    // 2.1
    public void printTripsWithEmployees() {
        this.tripsToEmployees.forEach(
            (trip, employee) -> {
                System.out.println("Trip: ");
                System.out.println(trip);
                System.out.println("Employee: ");
                System.out.println(employee);
            }
        );
    }

    // 2.2.
    public void printTripsWithMaxCustomersCount() {

        List<Trip> trips = new ArrayList<>(this.tripsToEmployees.keySet());

        int max = trips.stream().mapToInt(Trip::getCustomersSize).max().getAsInt();

        trips.stream()
            .filter(trip -> trip.getCustomersSize() == max)
            .collect(Collectors.toList())
            .forEach((trip) -> {
                System.out.println(trip);
            });
    }

    // 2.3.
    public void printSortedByTransportTypeAndDayCount() {
        List<Trip> trips = new ArrayList<>(this.tripsToEmployees.keySet());

        Collections
            .sort(
                trips,
                Trip.TransportTypeComparator.thenComparing(Trip.DaysCountComparator)
            );

        trips.forEach((trip -> System.out.println(trip)));
    }

    // 2.4.
    public void printTripWithMaxId() {
        List<Trip> trips = new ArrayList<>(this.tripsToEmployees.keySet());
        Trip tripWithMaxId =  Collections.max(trips, Comparator.comparing(trip -> trip.getId()));
        System.out.println(tripWithMaxId);
    }

    // 3.1.
    public void printRaffleParticipants() {
        this.raffleParticipants.forEach(raffleParticipant -> System.out.println(raffleParticipant));
    }

    // 3.2.
    public void printRaffleWinners() {
        List<Customer> participantList = new ArrayList(this.raffleParticipants);
        Collections.shuffle(participantList);

        participantList.subList(0, this.numberOfGifts).forEach(participant -> System.out.println(participant));
    }

    public String getName() {
        return name;
    }

    public int getNumberOfGifts() {
        return numberOfGifts;
    }

    @Override
    public String toString() {
        return "TravelAgency{" +
                "name='" + name + '\'' +
                ", numberOfGifts=" + numberOfGifts +
                '}';
    }
}
