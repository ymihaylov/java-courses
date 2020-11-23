import Exceptions.TripLimitReachedExceeded;

import java.util.*;

public class Trip implements Comparable<Trip> {
    private long id;
    private String destination;
    private Transport transport;
    private int numberOfDays;
    private int maxNumberOfCustomers;

    private Set<Customer> customers;

    public Trip(long id, String destination, Transport transport, int numberOfDays, int maxNumberOfCustomers) {
        this.id = id;
        this.destination = destination;
        this.transport = transport;
        this.numberOfDays = numberOfDays;
        this.maxNumberOfCustomers = maxNumberOfCustomers;

        this.customers = new LinkedHashSet<>();
    }

    // 1.1.
    public void addCustomer(Customer customer) throws TripLimitReachedExceeded {
        if (this.customers.size() == this.maxNumberOfCustomers) {
            throw new TripLimitReachedExceeded();
        }

        // It is a HashSet and this line of code will no add Customer, if the Customer is already in the HashSet
        this.customers.add(customer);
    }

    // 1.2.
    public void printCustomersByAge() {
        List<Customer> sortedList = new ArrayList<>(this.customers);
        Collections.sort(sortedList, Customer.AgeComparator);

        sortedList.forEach(customer -> System.out.println(customer));
    }

    // 1.3.
    public void printCustomersByOrderOfAdding() {
        // It is LinkedHashSet - It keeps order of adding by default
        this.customers.forEach(customer -> System.out.println(customer));
    }

    public Set<Customer> getCustomers() {
        return this.customers;
    }

    public int getCustomersSize() {
        return this.customers.size();
    }

    public long getId() {
        return id;
    }

    public String getDestination() {
        return destination;
    }

    public Transport getTransport() {
        return transport;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public int getMaxNumberOfCustomers() {
        return maxNumberOfCustomers;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", destination='" + destination + '\'' +
                ", transport=" + transport +
                ", numberOfDays=" + numberOfDays +
                ", maxNumberOfCustomers=" + maxNumberOfCustomers +
                '}';
    }

    @Override
    public int compareTo(Trip trip) {
        return Long.compare(trip.id, this.id);
    }

    public static Comparator<Trip> TransportTypeComparator = new Comparator<Trip>() {
        @Override
        public int compare(Trip trip1, Trip trip2) {
            return trip1.transport.compareTo(trip2.transport);
        }
    };

    public static Comparator<Trip> DaysCountComparator = new Comparator<Trip>() {
        @Override
        public int compare(Trip trip1, Trip trip2) {
            return Integer.compare(trip1.numberOfDays, trip2.numberOfDays);
        }
    };
}
