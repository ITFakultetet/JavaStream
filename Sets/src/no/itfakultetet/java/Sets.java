package no.itfakultetet.java;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Sets {

	public static void main(String[] args) {

		// Java 8 - HashSet, LinkedSet, TreeSet

		Set<Integer> hsett = new HashSet<>();
		hsett.add(5);
		hsett.add(15);
		hsett.add(3);
		hsett.add(54);
		hsett.add(2);
		hsett.add(54); // Merk - duplikater blir oversett siden et sett inneholder unike verdier
		hsett.add(102);

		System.out.println("hsett inneholder: " + hsett);

		System.out.println("Antall tall i hsett: " + hsett.size());

		// Bla igjennom alle elementenne i hsett med forbedret for-løkke

		System.out.println("hsett: ");
		int i = 1;
		for (Integer tall : hsett) {
			System.out.println("Tall nummer " + i + ": " + tall);
			i++;
		}

		// Bla igjennom alle elementenne i hsett med forEach()
		System.out.println("hsett med forEach(): ");

		hsett.forEach(System.out::println);

		System.out.println();
		
		// TreeSet - sett som sorterer automatisk
		
		TreeSet<String> tsett = new TreeSet<>();
		
		// Legg til flere navn med addAll()
		tsett.addAll(List.of("Ola","Petter","Åge","Kari","Eva"));
		
		// Skriv ut elementene i tsett
		System.out.println("Elementene i tsett er sortert alfabetisk: ");
		System.out.println(tsett);
		
		System.out.println();
		
		// Java 11 - immutable sett med Set.of()

		Set<Integer> sett1 = Set.of(2, 8, 5, 9, 34, 12, 67, 23, 78);
		Set<String> sett2 = Set.of("Oskar", "Kari", "Nils", "Eva");

		System.out.println("Sett1 består av: " + sett1);
		System.out.println("Sett2 består av: " + sett2);

		// Skriv ut Kari
		sett2.stream().filter(a -> a.contains("Kari")).forEach(System.out::println);

		System.out.println("Summen av tallene i sett1 er: " + sett1.stream().reduce((a, b) -> a + b).get());
		System.out.println("Summen av tallene i sett1 er: " + sett1.stream().mapToInt(a -> a).sum());

		System.out.println("Produktet av tallene i sett1 er: " + sett1.stream().reduce((a, b) -> a * b).get());

		System.out.print("Sett1 sortert: ");
		sett1.stream().sorted().forEach(a -> System.out.print(a + " "));

		System.out.println();

		System.out.print("Sett2 sortert: ");
		sett2.stream().sorted().forEach(a -> System.out.print(a + " "));

		System.out.println();

		System.out.print("Sett1 sortert i omvendt rekkefølge: ");
		sett1.stream().sorted(Comparator.reverseOrder()).forEach(a -> System.out.print(a + " "));

		System.out.println();

		System.out.print("Sett2 sortert i omvendt rekkefølge: ");
		sett2.stream().sorted(Comparator.reverseOrder()).forEach(a -> System.out.print(a + " "));

		System.out.println();

	}

}
