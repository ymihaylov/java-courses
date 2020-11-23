import java.util.Comparator;

public class Vehicle {
    private int weight;
    private boolean isEmergencyVehicle = false;

    public Vehicle(int weight) {
        this.weight = weight;
    }

    public Vehicle(int weight, boolean isEmergencyVehicle) {
        this.weight = weight;
        this.isEmergencyVehicle = isEmergencyVehicle;
    }

    public void process()
    {
        System.out.println("Processing " + this + " ...");
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "weight=" + weight +
                ", isEmergencyVehicle=" + isEmergencyVehicle +
                '}';
    }

    public static Comparator<Vehicle> ComparatorByVehicleWeight = new Comparator<Vehicle>() {
        @Override
        public int compare(Vehicle vehicle1, Vehicle vehicle2) {
            return Integer.compare(vehicle1.weight, vehicle2.weight);
        }
    };

    public static Comparator<Vehicle> ComparatorByVehicleEmergencyStatus = new Comparator<Vehicle>() {
        @Override
        public int compare(Vehicle vehicle1, Vehicle vehicle2) {
            return Boolean.compare(vehicle1.isEmergencyVehicle, vehicle2.isEmergencyVehicle);
        }
    };
}
