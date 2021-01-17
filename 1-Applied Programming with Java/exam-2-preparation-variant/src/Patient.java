public class Patient {
    private String name;
    private Diagnosis diagnosis;
    private int age;

    public Patient(String name, Diagnosis diagnosis, int age) {
        this.name = name;
        this.diagnosis = diagnosis;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public int getAge() {
        return age;
    }

    public boolean isUrgent() {
        return diagnosis.equals(Diagnosis.BRONCHITIS) || diagnosis.equals(Diagnosis.PNEUMONIA);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", diagnosis=" + diagnosis +
                ", age=" + age +
                '}';
    }
}
