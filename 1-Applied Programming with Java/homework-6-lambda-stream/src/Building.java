import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

public class Building implements Comparable<Building> {
    private long id;
    private String town;
    private double area;
    private int numberOfFloors;
    private static AtomicInteger numberOfBuildings = new AtomicInteger(0);

    public Building(String town, double area, int numberOfFloors) {
        this.id = this.numberOfBuildings.incrementAndGet();
        this.town = town;
        this.area = area;
        this.numberOfFloors = numberOfFloors;
    }

    public long getId() {
        return id;
    }

    public String getTown() {
        return town;
    }

    public double getArea() {
        return area;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    @Override
    public int compareTo(Building b) {
        return Long.compare(this.id, b.id);
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", town='" + town + '\'' +
                ", area=" + area +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }
}
