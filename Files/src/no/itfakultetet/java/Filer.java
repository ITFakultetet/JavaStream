package no.itfakultetet.java;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Filer {

	public static void main(String[] args) {

		try (FileWriter lagfil = new FileWriter("fil.txt")) {
			lagfil.write("Dette er en fil med litt tekst.\n");
			lagfil.append("Og her er en linje til.\n");
			lagfil.append("og dette er enda en linje - som er den siste.\n");
		} catch (Exception e) {
			System.out.println("Noe gikk galt under oppretting av fil.txt, fordi: " + e);
		}

		// Les fil med FileReader og Scanner

		System.out.println("Les filen med FileReader og BufferedReader og skriv den ut til skjermen:\n");

			try (FileReader lesfil = new FileReader("fil.txt")) {
			System.out.println("Innholdet av \"fil.txt\":");
			BufferedReader br1 = new BufferedReader(lesfil);
			String s = null;
			while ((s = br1.readLine()) != null) {
				System.out.println(s);
			}

			br1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		System.out.println("--------------------------------");
		
		// Les fil med FileInputStream

		System.out.println("Les filen med FileInputStream og Scanner og skriv den ut til skjermen:\n");

		try (FileInputStream fil = new FileInputStream("fil.txt")) {
			System.out.println("Innholdet av \"fil.txt\" med FileInputStream:");
			Scanner sc1 = new Scanner(fil);
			while (sc1.hasNextLine()) {
				System.out.println(sc1.nextLine());
			}
			sc1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		System.out.println("--------------------------------");
		
		// Les filen med Files.lines()
		// Loop gjennom linjene i en fil med Files.lines

		System.out.println("Bruk Files.lines() til å skrive ut linjer som begynner med \"Og\" med store bokstaver: \n");

		try {
			Files.lines(Paths.get("fil.txt")).filter(line -> line.startsWith("Og")).map(String::toUpperCase)
					.forEach(System.out::println);
		} catch (Exception e) {
			System.out.println("Noe gikk galt fordi: " + e);
			System.out.println("Stacktrace:");
			e.printStackTrace();
		}

	}

}
