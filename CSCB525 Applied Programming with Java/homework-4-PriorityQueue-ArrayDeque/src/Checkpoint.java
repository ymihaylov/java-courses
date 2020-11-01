import java.util.PriorityQueue;
import java.util.Queue;

public class Checkpoint {
    private String name;

    private Queue<Vehicle> queueOfVehicles;

    public Checkpoint(String name) {
        this.name = name;
        this.queueOfVehicles = new PriorityQueue(Vehicle.ComparatorByVehicleEmergencyStatus.reversed().thenComparing(Vehicle.ComparatorByVehicleWeight));
    }

    public void addVehicle(Vehicle vehicle) {
        this.queueOfVehicles.offer(vehicle);
    }

    public Vehicle pollVehicle() {
        return this.queueOfVehicles.poll();
    }

    public void processVehicles()
    {
        if (this.queueOfVehicles.isEmpty()) {
            System.out.println("There are no vehicles in the queue!");
            return;
        }

        Vehicle vehicle;
        while ((vehicle = this.pollVehicle()) != null) {
            vehicle.process();
        }

        System.out.println("All vehicles are process!");
    }
}
