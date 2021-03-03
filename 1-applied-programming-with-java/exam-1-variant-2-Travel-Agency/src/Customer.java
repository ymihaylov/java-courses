import java.util.Comparator;

public class Customer implements Comparable<Customer> {
    private long id;
    private String name;
    private int age;

    public Customer(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static Comparator<Customer> AgeComparator = new Comparator<Customer>() {
        @Override
        public int compare(Customer customer1, Customer customer2) {
            return Integer.compare(customer1.age, customer2.age);
        }
    };

    @Override
    public int compareTo(Customer customer) {
        return customer.name.compareTo(this.name);
    }
}
