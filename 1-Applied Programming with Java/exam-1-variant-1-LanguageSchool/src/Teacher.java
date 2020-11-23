public class Teacher implements Comparable<Teacher> {
    private long id;
    private String name;
    private Language language;

    public Teacher(long id, String name, Language language) {
        this.id = id;
        this.name = name;
        this.language = language;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Language getLanguage() {
        return language;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", language=" + language +
                '}';
    }

    @Override
    public int compareTo(Teacher teacher) {
        return teacher.name.compareTo(this.name);
    }
}
