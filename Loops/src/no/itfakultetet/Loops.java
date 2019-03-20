package no.itfakultetet;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Loops {

	public static void main(String[] args) {

		// while - løkke
		System.out.println("while-løkke");

		int i = 0;
		while (i < 6) {
			System.out.println("Verdien er: " + i);
			i = i + 1;
		}

		// do while -løkke (kjøre alltid minst 1 gang)
		System.out.println("\ndo while-løkke");
		i = 8;
		do {
			if (i > 6) {
				System.out.println("Verdien er større enn 6.");
			} else {
				System.out.println("Verdien er: " + i);
			}

			i++;
		} while (i <= 6);

		// for - løkke (alle betingelsene inne i parentesen)

		System.out.println("\nfor-løkke");
		for (int j = 1; j < 6; j++) {
			System.out.println("Verdien er: " + j);
		}

		// Bla igjennom et array med for

		String[] dyr = { "Katt", "Hund", "Edderkopp", "Kanin" };

		System.out.println("\nfor:");
		for (String dyret : dyr) {
			System.out.println(dyret);
		}

		// Java 10+: forEach-løkke med List.of og Map.entrySet.of()- - som lager ojekter
		// som er "immutable" (som ikke kan endres) .

		System.out.println("\nList med forEach:");
		List<String> dyr2 = List.of("Ku", "Okse", "Gris", "Geit");

		dyr2.forEach(System.out::println);

		System.out.println("\nMap entrySet med forEach:");
		Map<String, String> dyr3 = Map.ofEntries(Map.entry("Dagros", "Ku"), Map.entry("Ferdinand", "Okse"),
				Map.entry("Miss Piggy", "Gris"), Map.entry("Bukken", "Geit"));

		dyr3.entrySet().forEach(System.out::println);

		// Løkke som blar igjennom linjer i en tekstfil

		// Først lag en fil med litt tekst
		try {
			String tekst = "Dette er en tekst.\nOg dette er en linje til.\nOg dette også";
			FileWriter fil = new FileWriter("test.txt");
			fil.write(tekst);
			fil.close();
		} catch (Exception e) {
			System.out.println("Kunne ikke opprette eller skrive til filen fordi: " + e);
			System.out.println("Stacktrace:");
			e.printStackTrace();
		}

		// Loop gjennom linjene i en fil med Files.lines

		try {
			Files.lines(Paths.get("test.txt")).filter(line -> line.startsWith("Og")).map(String::toUpperCase)
					.forEach(System.out::println);
		} catch (Exception e) {
			System.out.println("Noe gikk galt fordi: " + e);
			System.out.println("Stacktrace:");
			e.printStackTrace();
		}

	}

}
