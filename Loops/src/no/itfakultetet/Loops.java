package no.itfakultetet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Loops {

	public static void main(String[] args) throws IOException {

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

		// Java 10+: forEach-løkke med List-literal- som kan brukes til alt som kan blas
		// igjennom (iterables)

		System.out.println("\nforEach:");
		List<String> dyr2 = List.of("Ku", "Okse", "Gris", "Geit");

		dyr2.forEach(d -> System.out.println(d));

		// Loop gjennom linjene i en fil med Files.lines
		
		Files.lines(Paths.get("/home/terje/test.txt"))
		.filter(line -> line.startsWith("Og"))
		.map(String::toUpperCase)
		.forEach(System.out::println);

	}

}
