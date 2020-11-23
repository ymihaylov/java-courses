import java.util.Comparator;

public class Student implements Comparable<Student> {
    private long id;
    private String name;

    public Student(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static Comparator<Student> StudentName = new Comparator<Student>() {
        @Override
        public int compare(Student student1, Student student2) {

            return student1.name.compareTo(student2.name);
        }
    };

    @Override
    public int compareTo(Student student) {
        return student.name.compareTo(this.name);
    }
}
