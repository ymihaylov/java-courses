public class Citizen {
    private long id;
    private String name;
    private int numberOfChildren;

    public Citizen(long id, String name, int numberOfChildren) {
        this.id = id;
        this.name = name;
        this.numberOfChildren = numberOfChildren;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfChildren=" + numberOfChildren +
                '}';
    }
}
