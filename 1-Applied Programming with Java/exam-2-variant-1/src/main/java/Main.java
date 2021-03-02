import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        Car car1 = new Car("Mercedes", Color.BLUE, BigDecimal.valueOf(50_000));
        Car car2 = new Car("Mercedes", Color.BLUE, BigDecimal.valueOf(40_000));
        Car car3 = new Car("Mercedes", Color.BLUE, BigDecimal.valueOf(30_000));
        Car car4 = new Car("Pegeout", Color.RED, BigDecimal.valueOf(50_000));
        Car car5 = new Car("Pegeout", Color.RED, BigDecimal.valueOf(52_000));
        Car car6 = new Car("Pegeout", Color.RED, BigDecimal.valueOf(33_000));
        Car car7 = new Car("Mazda", Color.GREEN, BigDecimal.valueOf(52_000));
        Car car8 = new Car("Mazda", Color.GREEN, BigDecimal.valueOf(25_000));

        Set<Car> cars = new HashSet<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);
        cars.add(car7);
        cars.add(car8);

        Map<Car, LocalDate> carsSold = new HashMap<>();
        carsSold.put(car1, LocalDate.of(2021, 1, 8));
        carsSold.put(car2, LocalDate.of(2020, 12, 2));
        carsSold.put(car3, LocalDate.of(2020, 12, 1));
        carsSold.put(car4, LocalDate.of(2021, 1, 9));
        carsSold.put(car5, LocalDate.of(2020, 11, 8));

        System.out.println("---------------------------- Task 1.1 ----------------------------");
        cars.stream()
            .sorted(Comparator.comparing(Car::getColor).thenComparing(Car::getPrice, Comparator.reverseOrder()))
            .forEach(System.out::println);

        System.out.println("---------------------------- Task 1.2 ----------------------------");
        cars.stream()
            // Only > as the task description, not >= 40_000
            .filter(car -> car.getPrice().compareTo(new BigDecimal(40_000)) == 1 && car.getBrand().startsWith("M"))
            .forEach(System.out::println);

        System.out.println("---------------------------- Task 1.3 ----------------------------");
        long count = cars.stream()
            .filter(car -> car.getBrand().contains("e"))
            .count();
        System.out.println("Count of cars with brand name contains symbol e: " + count);

        System.out.println("---------------------------- Task 1.4 ----------------------------");
        BigDecimal maxPrice = cars.stream().max(Comparator.comparing(Car::getPrice)).get().getPrice();
        Set<Car> mostExpensiveCars = cars.stream()
                .filter(car -> car.getPrice().compareTo(maxPrice) == 0)
                .collect(Collectors.toSet());
        mostExpensiveCars.forEach(System.out::println);

        System.out.println("---------------------------- Task 1.5 ----------------------------");
        carsSold.entrySet().stream()
                .filter(carLocalDateEntry -> carLocalDateEntry.getValue().isAfter(LocalDate.of(2020, 12, 31)))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList())
                .forEach((System.out::println));

        System.out.println("---------------------------- Task 1.6 ----------------------------");
        carsSold.keySet().stream()
                .sorted(Comparator.comparing(Car::getPrice).reversed())
                .forEach((System.out::println));

        System.out.println("---------------------------- Task 2 ----------------------------");
        // exam-2/src/test/java/CarTest.java

        System.out.println("---------------------------- Task 3 ----------------------------");
        // Working Hours: ([\w: ]*)
        String regex = "Working Hours: ([\\w: ]*)";
        Pattern pattern = Pattern.compile(regex);

        BufferedReader bufferedReader = new BufferedReader(new FileReader("ShopsV1.txt"));
        List<String> workingHours = new ArrayList<>();

        String fileLine;
        while ((fileLine = bufferedReader.readLine()) != null) {
            Matcher matcher = pattern.matcher(fileLine);
            while (matcher.find()) {
                workingHours.add(matcher.group(1));
            }
        }

        workingHours.forEach(System.out::println);

        System.out.println("---------------------------- Task 4 ----------------------------");
        int nThreads = 4;
        ExecutorService executorServiceFixedPool = Executors.newFixedThreadPool(nThreads);
        cars.stream().limit(nThreads).forEach(car -> executorServiceFixedPool.submit(car));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorServiceFixedPool.shutdown();
    }
}
