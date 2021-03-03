import exceptions.SetTeacherWithDifferentLanguageException;

import java.util.*;
import java.util.stream.Collectors;

public class LanguageSchool {
    private String name;

    private Map<Course, Teacher> courses;

    private PriorityQueue<Teacher> teacherTrainingQueue;

    public LanguageSchool(String name) {
        this.name = name;
        this.courses = new HashMap<>();
        this.teacherTrainingQueue = new PriorityQueue<Teacher>(Comparator.comparingInt(t -> t.getLanguage().getPriority()));
    }

    public void addCourse(Course course, Teacher teacher) throws SetTeacherWithDifferentLanguageException {
        if (teacher.getLanguage() != course.getLanguage()) {
            throw new SetTeacherWithDifferentLanguageException();
        }

        this.courses.put(course, teacher);

        // 3.1
        if (!this.teacherTrainingQueue.contains(teacher)) {
            this.teacherTrainingQueue.add(teacher);
        }
    }

    public String getName() {
        return name;
    }

    // 2.1
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

    // 2.2
    public void printCoursesWithStudents() {
        this.courses.forEach(
            (course, teacher) -> {
                System.out.println("Course: ");
                System.out.println(course);
                course.printStudentsOrderedByName();
            }
        );
    }

    // 2.3
    public void showCoursesByLangAndTeacherId(Language language, int teacherId) {
        this.courses.entrySet().stream()
            .filter(entry -> entry.getValue().getLanguage() == language && entry.getValue().getId() == teacherId)
            .map(e -> e.getKey())
            .collect(Collectors.toList())
            .forEach((course) -> {
                System.out.println(course);
            });
    }

    // 2.4
    public void showCoursesBellowAdvanced() {
        this.courses.keySet().forEach((course -> {
            if (course.getLevel().getLevelNumber() < Level.ADVANCED.getLevelNumber()) {
                System.out.println(course);
            }
        }));
    }

    // 3.2
    public void showTeacherTrainingQueue() {
        this.teacherTrainingQueue.forEach(teacher -> System.out.println(teacher));
    }

    @Override
    public String toString() {
        return "LanguageSchool{" +
                "name='" + name + '\'' +
                '}';
    }
}
