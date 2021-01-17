import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args)  {
        Patient patient1 = new Patient("Maria Tsvetanova Petrova", Diagnosis.ANGINA, 28);
        Patient patient2 = new Patient("Ivan Georgiev Petrov", Diagnosis.ANGINA, 13);
        Patient patient3 = new Patient("Anelia Georgieva Tosheva", Diagnosis.BRONCHITIS, 17);
        Patient patient4 = new Patient("Ivanna Angelova Todorova", Diagnosis.BRONCHITIS, 7);
        Patient patient5 = new Patient("Petia Todorova Pesheva", Diagnosis.PNEUMONIA, 7);
        Patient patient6 = new Patient("Monika Teodosieva Ivanova", Diagnosis.BRONCHITIS, 9);

        List<Patient> patientList = Arrays.asList(patient1, patient1, patient2, patient2, patient3, patient3, patient3, patient4, patient5, patient5, patient5, patient6, patient6);

        Map<Integer, Patient> catalog = new TreeMap<>();

        catalog.put(1, patient1);
        catalog.put(2, patient2);
        catalog.put(3, patient3);
        catalog.put(4, patient4);
        catalog.put(5, patient5);
        catalog.put(6, patient1);
        catalog.put(7, patient1);
        catalog.put(8, patient1);
        catalog.put(9, patient6);

        // Task 1
        {
            System.out.println("-------------------Task 1.1.-----------------------");
            patientList.stream().sorted(Comparator.comparing(Patient::getName).reversed()).forEach(System.out::println);

            System.out.println("-------------------Task 1.2.-----------------------");
            patientList.stream()
                    .sorted(Comparator.comparing(Patient::getDiagnosis)
                    .thenComparing(Patient::getAge))
                    .forEach(System.out::println);

            System.out.println("-------------------Task 1.3.-----------------------");
            patientList.stream()
                    .filter(patient -> patient.getDiagnosis() == Diagnosis.BRONCHITIS)
                    .forEach(System.out::println);

            System.out.println("-------------------Task 1.4.-----------------------");
            patientList.stream()
                    .sorted(Comparator.comparing(Patient::getAge).reversed())
                    .limit(3)
                    .forEach(System.out::println);

            System.out.println("-------------------Task 1.5.-----------------------");
            patientList.stream()
                    .sorted(Comparator.comparing(Patient::getAge))
                    .limit(1)
                    .forEach(System.out::println);

            System.out.println("-------------------Task 1.6.-----------------------");
            patientList.stream().distinct().forEach(System.out::println);

            System.out.println("-------------------Task 1.7.-----------------------");
            patientList.stream().filter(patient -> patient.getName().startsWith("M")).forEach(System.out::println);

            System.out.println("-------------------Task 1.8.-----------------------");
            List<Patient> bronchitisPatientsUnder12 = patientList.stream()
                    .filter(patient -> patient.getDiagnosis().equals(Diagnosis.BRONCHITIS) && patient.getAge() < 12)
                    .collect(Collectors.toList());
            bronchitisPatientsUnder12.forEach(System.out::println);

            System.out.println("-------------------Task 1.9.-----------------------");
            List<Patient> petrovPatients = patientList.stream()
                    .filter(patient -> Arrays.asList(patient.getName().split(" ")).contains("Petrov"))
                    .sorted(Comparator.comparing(Patient::getName))
                    .collect(Collectors.toList());
            petrovPatients.forEach(System.out::println);

            System.out.println("-------------------Task 1.10.-----------------------");
            catalog.keySet().stream().filter(key -> key < 7).map(key -> catalog.get(key)).forEach(System.out::println);
        }

        // Task 3
        {
            // Patern is (#\w*# - )([\w ]*)
        }
    }
}


