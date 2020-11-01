public class Main {
    public static void main(String[] args) {
        Vehicle smallCar = new Vehicle(1200);
        Vehicle mediumCar = new Vehicle(1600);
        Vehicle bigCar = new Vehicle(2000);

        Vehicle ambulance = new Vehicle(2000, true);
        Vehicle fireTruck = new Vehicle(2500, true);

        Checkpoint checkpoint = new Checkpoint("Checkpoint 1");
        checkpoint.addVehicle(bigCar);

        checkpoint.addVehicle(fireTruck);

        checkpoint.addVehicle(mediumCar);
        checkpoint.addVehicle(smallCar);


        checkpoint.addVehicle(ambulance);
        checkpoint.addVehicle(new Vehicle(800));
        checkpoint.processVehicles();
    }
}
