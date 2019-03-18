package no.itfakultetet.java;

import java.io.FileWriter;
import java.util.Scanner;

public class Filer {

	public static void main(String[] args) {

		try (FileWriter lagfil = new FileWriter("fil.txt")) {
			lagfil.write("Dette er en fil med litt tekst.\n");
			lagfil.append("Og her en linje til.\n");
			lagfil.append("og dette er enda en linje.\n");
		} catch (Exception e) {
			System.out.println("Noe gikk galt under oppretting av fil.txt, fordi: " + e);
		}

		Scanner sc1 = new Scanner("fil.txt");
		
		 while (sc1.hasNextLine()) {
			System.out.println(sc1.nextLine()); 
		}
		
		sc1.close();
	}

}
