public class Employee {
    private long id;
    private String name;
    private Rank rank;

    public Employee(long id, String name, Rank rank) {
        this.id = id;
        this.name = name;
        this.rank = rank;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rank=" + rank +
                '}';
    }
}

