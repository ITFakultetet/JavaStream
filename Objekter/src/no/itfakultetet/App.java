package no.itfakultetet;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {

        Car car1 = new Car("Mercedes c180",2006,62000);
        Car car2 = new Car("Volvo v90",2014,45000);
        Car car3 = new Car("Nissan Leaf",2018,53000);
        Car car4 = new Car("Nissan Leaf",2017,50000);

        List<Car> cars = List.of(car1,car2,car3,car4);

        // Print out all car makes with forEach()
        System.out.println("\nAll cars, sorted by price");
        cars.stream()
                .sorted(Comparator.comparing(Car::getPrice))
                .forEach(a -> System.out.println(a.getMake()+" - "+a.getPrice()));

        // Print out number of Nissan cars available
        System.out.print("Number of Nissan cars: ");
        System.out.println(cars.stream()
                .filter(a -> a.getMake().contains("Nissan"))
                .count());

        // Filter out all cars older than 2018
        System.out.println("\nModels from before 2018");
        cars.stream()
                .filter(a -> a.getModel() < 2018)
                .forEach(a -> System.out.println(a.getMake() +" "+ a.getModel()));

        // Make a list of car makes
        List<String> carMakes = cars.stream().map(a -> a.getMake()).collect(Collectors.toList());
        // Alternative with method reference
        List<String> carMakes2 = cars.stream().map(Car::getMake).collect(Collectors.toList());


        // Print out all car makes from list with method reference to println
        System.out.println("\nAll Car Makes from new list");
        carMakes.forEach(System.out::println);

        // Print out average price of all cars
        System.out.println("\nAverage Car Price:");
        System.out.println(cars.stream()
                .collect(Collectors.averagingInt(a -> a.getPrice())));

        // Print out average price of all Nissan cars
        System.out.println("\nAverage Nissan Price:");
        System.out.println(cars.stream()
                .filter(a-> a.getMake().contains("Nissan"))
                .collect(Collectors.averagingInt(a -> a.getPrice())));

        // Alternative with method reference
        System.out.println(cars.stream()
                .filter(a-> a.getMake().contains("Nissan"))
                .collect(Collectors.averagingInt(Car::getPrice)));

        // Alternative with mapToInt
        System.out.println(cars.stream()
                .filter(a-> a.getMake().contains("Nissan"))
                .mapToInt(Car::getPrice)
                .average().getAsDouble());


        // Print out price of all cars with peek(), followed by the average price
        System.out.println("\nPrices and Average Price:");
        System.out.println(cars.stream()
                .peek(a-> System.out.println(a.getPrice()))
                .collect(Collectors.averagingInt(a -> a.getPrice())));


        // Print out cheapest car price
        System.out.println("\nLeast expensive car price:");
        System.out.println(cars.stream().map(a->a.getPrice()).reduce(Math::min).get());
        System.out.println(cars.stream().mapToInt(a->a.getPrice()).min().getAsInt());

        // Print out most expensive car price
        System.out.println("\nMost expensive car price:");
        System.out.println(cars.stream().map(Car::getPrice).max(Integer::compareTo).get());
        //Alternative
        System.out.println(cars.stream().mapToInt(Car::getPrice).max().getAsInt());

        // Print out most expensive car
        System.out.println("\nMost expensive car:");
        System.out.println(cars.stream().max((a,b) -> a.getPrice()).get());

        // Print out unique car makes
        System.out.println("\nCar makes available:");
        cars.stream().map(Car::getMake).distinct().forEach(System.out::println);

        // Print out price statistics
        System.out.println("\nPrice Stats:");
        System.out.println(cars.stream()
                .collect(Collectors.summarizingInt(Car::getPrice)));


        // Put price statistics in a variable <stats>. and print out each item
        System.out.println("\nPrice Stats:");
        IntSummaryStatistics stats = cars.stream()
                .collect(Collectors.summarizingInt(Car::getPrice));

        System.out.println("Max price: "+stats.getMax());
        System.out.println("Min price: "+stats.getMin());
        System.out.println("Average price: "+ Math.round(stats.getAverage()));
        System.out.println("Value of all cars: "+stats.getSum());





    }
}
