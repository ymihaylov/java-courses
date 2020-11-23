public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(1, "Aleksander Petrov");
        Student student2 = new Student(2, "Peter Petrov");
        Student student3 = new Student(3, "Georgi Petrov");
        Student student4 = new Student(4, "Boris Borisov");

        Teacher teacher = new Teacher(1, "Petar Petrov", Language.ENGLISH);
        Course course1 = new Course(Language.ENGLISH, Level.INTERMEDIATE, 10, teacher);
        Course course2 = new Course(Language.ENGLISH, Level.INTERMEDIATE, 10, teacher);

        LanguageSchool languageSchool = new LanguageSchool("Britanika");

        try {
            course1.addStudent(student2);
            course1.addStudent(student3);
            course1.addStudent(student1);
            course1.addStudent(student4);

            course1.printStudentsByOrderOfAdding();
            System.out.println("...");
            course1.printStudentsOrderByName();

            languageSchool.addCourse(course1);
            System.out.println("...");
            languageSchool.printCoursesWithStudents();
            System.out.println("...");

            languageSchool.showCoursesByLangAndTeacherId(Language.ENGLISH, 2);
        } catch (Exception e) {}


        System.out.println("hello");
    }
}
