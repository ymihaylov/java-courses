import Exceptions.TripLimitReachedExceeded;

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer(1, "Aleksander Petrov", 25);
        Customer customer2 = new Customer(2, "Peter Petrov", 40);
        Customer customer3 = new Customer(3, "Georgi Petrov", 51);
        Customer customer4 = new Customer(4, "Boris Borisov", 20);

        Employee employee1 = new Employee(1, "Employee 1");
        Employee employee2 = new Employee(2, "Employee 2");
        Employee employee3 = new Employee(3, "Employee 2");

        try {
            Trip trip1 = new Trip(1, "Turkey", Transport.BUS, 10, 5);
            trip1.addCustomer(customer2);
            trip1.addCustomer(customer1);
            trip1.addCustomer(customer3);
            trip1.addCustomer(customer4);


            Trip trip2 = new Trip(2, "Italy", Transport.PlANE, 4, 10);
            trip2.addCustomer(customer1);
            trip2.addCustomer(customer2);
            trip2.addCustomer(customer3);
            trip2.addCustomer(customer4);


            Trip trip3 = new Trip(3, "Palma", Transport.PlANE, 4, 2);
            trip3.addCustomer(customer1);
            trip3.addCustomer(customer2);

            trip1.printCustomersByAge();
            System.out.println("-----");
            trip1.printCustomersByOrderOfAdding();

            System.out.println("-----");
            TravelAgency travelAgency = new TravelAgency("Java Travel", 2);
            travelAgency.addTrip(trip3, employee3);
            travelAgency.addTrip(trip2, employee1);
            travelAgency.addTrip(trip1, employee2);

            travelAgency.printTripsWithEmployees();
            System.out.println("-----");
            travelAgency.printTripsWithMaxCustomersCount();

            System.out.println("-----");
            travelAgency.printSortedByTransportTypeAndDayCount();

            System.out.println("-----");
            travelAgency.printTripWithMaxId();

            System.out.println("-----");
            travelAgency.printRaffleParticipants();

            System.out.println("-----");
            System.out.println("-----");
            System.out.println("-----");
            travelAgency.printRaffleWinners();
        } catch (TripLimitReachedExceeded e) {
            System.out.println("Fail");
        }
    }
}
