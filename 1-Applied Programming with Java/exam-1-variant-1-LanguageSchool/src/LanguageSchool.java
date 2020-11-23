import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class LanguageSchool {
    private String name;

    private Map<Course, Teacher> courses;

    public LanguageSchool(String name) {
        this.name = name;
        this.courses = new HashMap<>();
    }

    public void addCourse(Course course) {
        this.courses.put(course, course.getTeacher());
    }

    public String getName() {
        return name;
    }

    public void printCoursesWithTeachers() {
        this.courses.forEach(
            (course, teacher) -> {
                System.out.println("Teacher: ");
                System.out.println(teacher);
                System.out.println("Course: ");
                System.out.println(course);
            }
        );
    }

    public void printCoursesWithStudents() {
        this.courses.forEach(
                (course, teacher) -> {
                    System.out.println("Course: ");
                    System.out.println(course);
                    course.printStudentsOrderByName();
                }
        );
    }

    public void showCoursesByLangAndTeacherId(Language language, int id) {
        this.courses.entrySet().stream()
                .filter(entry -> entry.getValue().getLanguage() == language && entry.getValue().getId() == id)
                .map(e -> e.getKey()).collect(Collectors.toList())
                .forEach((course) -> {
                    System.out.println(course);
                });
    }

    public void showCoursesBellowAdvanced() {
        this.courses.keySet().forEach((course -> {
            if (course.getLevel().)
        }));
    }

    @Override
    public String toString() {
        return "LanguageSchool{" +
                "name='" + name + '\'' +
                '}';
    }
}
