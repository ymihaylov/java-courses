import exceptions.CourseLimitReachedExceeded;
import exceptions.SetTeacherWithDifferentLanguageException;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(1, "Aleksander Petrov");
        Student student2 = new Student(2, "Peter Petrov");
        Student student3 = new Student(3, "Georgi Petrov");
        Student student4 = new Student(4, "Boris Borisov");

        Teacher teacher1 = new Teacher(1, "Petar Petrov", Language.ENGLISH);
        Teacher teacher2 = new Teacher(2, "Georgi French", Language.FRENCH);
        Teacher teacher3 = new Teacher(3, "Georgi DE", Language.GERMAN);

        Course course1 = new Course(Language.ENGLISH, Level.INTERMEDIATE, 10);
        Course course2 = new Course(Language.FRENCH, Level.ADVANCED, 10);
        Course course3 = new Course(Language.GERMAN, Level.ADVANCED, 10);

        LanguageSchool languageSchool = new LanguageSchool("Britanika");

        try {
            course1.addStudent(student2);
            course1.addStudent(student3);
            course1.addStudent(student1);
            course1.addStudent(student4);

            languageSchool.addCourse(course2, teacher2);
            languageSchool.addCourse(course1, teacher1);
            languageSchool.addCourse(course3, teacher3);
//            languageSchool.printCoursesWithStudents();
//            System.out.println("...");

            languageSchool.showTeacherTrainingQueue();
        } catch (CourseLimitReachedExceeded e) {
        } catch (SetTeacherWithDifferentLanguageException e) {}


        System.out.println("hello");
    }
}
