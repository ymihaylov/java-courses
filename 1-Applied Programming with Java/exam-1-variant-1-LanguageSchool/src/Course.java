import exceptions.CourseLimitReachedExceeded;
import exceptions.SetTeacherWithDifferentLanguageException;

import java.util.*;

public class Course implements Comparable<Course> {
    private Language language;
    private Level level;
    private int maxNumberOfStudents;

    private Teacher teacher;

    private Set<Student> students;

    public Course(Language language, Level level, int maxNumberOfStudents, Teacher teacher) {
        this.language = language;
        this.level = level;
        this.maxNumberOfStudents = maxNumberOfStudents;

        this.students = new LinkedHashSet<>();

        try {
            this.setTeacher(teacher);
        } catch (Exception e) {}
    }

    public Language getLanguage() {
        return language;
    }

    public Level getLevel() {
        return level;
    }

    public int getMaxNumberOfStudents() {
        return maxNumberOfStudents;
    }

    public void setTeacher(Teacher teacher) throws SetTeacherWithDifferentLanguageException {
        if (teacher.getLanguage() != this.getLanguage()) {
            throw new SetTeacherWithDifferentLanguageException();
        }

        this.teacher = teacher;
    }

    public void addStudent(Student student) throws CourseLimitReachedExceeded {
        if (this.students.size() >= this.maxNumberOfStudents) {
            throw new CourseLimitReachedExceeded();
        }

        // It is a HashSet and this line of code will no add Student, if the Student is already in the HashSet
        this.students.add(student);
    }

    public void printStudentsByOrderOfAdding() {
        // It is LinkedHashSet - It keeps order of adding by default
        this.students.forEach(student -> System.out.println(student));
    }

    public void printStudentsOrderByName() {
        List<Student> sortedList = new ArrayList<>(this.students);
        Collections.sort(sortedList, Student.StudentName);

        sortedList.forEach(student -> System.out.println(student));
    }

    public Teacher getTeacher() {
        return teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "language=" + language +
                ", level=" + level +
                ", maxNumberOfStudents=" + maxNumberOfStudents +
                '}';
    }

    @Override
    public int compareTo(Course course) {
        return course.level.compareTo(this.level);
    }
}
