public class Municipality {
    private String name;
    private int numberOfHouses;

    public Municipality(String name, int numberOfHouses) {
        this.name = name;
        this.numberOfHouses = numberOfHouses;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfHouses() {
        return numberOfHouses;
    }

    @Override
    public String toString() {
        return "Municipality{" +
                "name='" + name + '\'' +
                ", numberOfHouses=" + numberOfHouses +
                '}';
    }
}
