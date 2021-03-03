import javax.swing.plaf.basic.BasicDesktopIconUI;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Building building1 = new Building("Sofia", 200, 3);
        Building building2 = new Building("Sofia", 300, 4);
        Building building3 = new Building("Sofia", 200, 5);
        Building building4 = new Building("Varna", 400, 3);
        Building building5 = new Building("Varna", 250, 3);
        Building building6 = new Building("Burgas", 200, 4);
        Building building7 = new Building("Plovdiv", 250, 5);
        Building building8 = new Building("Plovdiv", 420, 5);
        Building building9 = new Building("Varna", 500, 3);
        Building building10 = new Building("Burgas", 500, 4);

        // Changed from HashSet to TreeSet to satisfy the requirement "default order of building is always by ID";
        Set<Building> buildingSet = new TreeSet<>();
        buildingSet.add(building2);
        buildingSet.add(building3);
        buildingSet.add(building4);
        buildingSet.add(building5);
        buildingSet.add(building6);
        buildingSet.add(building7);
        buildingSet.add(building8);
        buildingSet.add(building9);
        buildingSet.add(building10);
        buildingSet.add(building1);

        System.out.println("--------------------------- Task 1.а ---------------------------");
        buildingSet.forEach((building -> System.out.println(building)));

        System.out.println("--------------------------- Task 1.b ---------------------------");
        buildingSet.stream()
            .filter(building -> building.getTown() == "Sofia" && building.getArea() >= 200)
            .forEach(System.out::println);

        System.out.println("--------------------------- Task 1.c ---------------------------");
        buildingSet.stream()
            .filter(building -> building.getNumberOfFloors() > 3)
            .sorted(Comparator.comparing(Building::getArea))
            .forEach(System.out::println);

        System.out.println("--------------------------- Task 1.d ---------------------------");
        buildingSet.stream()
                .sorted(
                    Comparator.comparing(Building::getTown).thenComparing(Building::getArea)
                )
                .forEach(System.out::println);

        System.out.println("--------------------------- Task 1.e ---------------------------");
        double sumAreas = buildingSet.stream().collect(Collectors.summingDouble(Building::getArea));
        System.out.println(sumAreas);

        System.out.println("--------------------------- Task 1.f ---------------------------");
        long townsEndsWithVCount = buildingSet.stream().filter(building -> building.getTown().endsWith("v")).count();
        System.out.println(townsEndsWithVCount);

        System.out.println("--------------------------- Task 1.g ---------------------------");
        Set<Building> buildingWithMinNumberOfFloors = new HashSet<>();
        int minFloorsCount = buildingSet.stream().mapToInt(building -> building.getNumberOfFloors()).min().getAsInt();
        buildingSet.stream().filter(building -> building.getNumberOfFloors() == minFloorsCount).forEach(buildingWithMinNumberOfFloors::add);
        buildingWithMinNumberOfFloors.stream().forEach(System.out::println);


        Map<Building, Double> buildingsPrices = new HashMap();
        buildingsPrices.put(building1, 100000.0);
        buildingsPrices.put(building2, 200000.0);
        buildingsPrices.put(building3, 100000.0);
        buildingsPrices.put(building4, 200000.0);
        buildingsPrices.put(building5, 100000.0);
        buildingsPrices.put(building6, 100000.0);
        buildingsPrices.put(building7, 300000.0);
        buildingsPrices.put(building8, 500000.0);
        buildingsPrices.put(building9, 100000.0);
        buildingsPrices.put(building10, 400000.0);

        System.out.println("--------------------------- Task 2.a ---------------------------");
        buildingsPrices.entrySet().stream().filter(entry -> entry.getValue() > 100_000).forEach(System.out::println);

        System.out.println("--------------------------- Task 2.b ---------------------------");
        double average = buildingsPrices.entrySet().stream().mapToDouble(entry -> entry.getValue()).average().orElse(0);
        System.out.println(average);
        List<Double> pricesLessThanAverage = buildingsPrices
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() <= average)
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());

        pricesLessThanAverage.forEach(System.out::println);

        System.out.println("--------------------------- Task 2.b Variant 2 ---------------------------");
        double averagePrice = buildingsPrices.values().stream().reduce(0., (a, b) -> a + b) / buildingsPrices.size();
        System.out.println("Average building price: " + averagePrice);
        List<Double> pricesLessThanAverage2 = buildingsPrices.values()
                .stream().filter(price -> price < averagePrice).collect(Collectors.toList());
        pricesLessThanAverage2.stream().forEach(System.out::println);
    }
}
