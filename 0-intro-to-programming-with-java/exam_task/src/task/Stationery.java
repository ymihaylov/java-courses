package task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Stationery {
    protected int inventoryNumber;
    protected String manufacturer;
    protected double price;

    public Stationery(int inventoryNumber, String manufacturer, double price) {
        this.inventoryNumber = inventoryNumber;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public void writeDataToFile() {
        File file = new File("stationaryData.txt");
        try {
            FileWriter fr = new FileWriter(file, true);
            fr.write("Inventory number: " + this.inventoryNumber + "\n");
            fr.write("Manufacturer: " + this.manufacturer + "\n");
            fr.write("Price: " + this.price + "\n");
            fr.write("----------\n");
            fr.close();
        } catch (IOException e) {
            System.out.println("Failed to write in stationary data!");
        }
    }
}
