package no.itfakultetet;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayEks {

	public static void main(String[] args) {

		// Lag et enkelt array - tall - bestående av elementer av typen heltall
		Integer[] tall = { 12, 34, 2, 67 };

		// Skriv ut med for-løkke
		System.out.println("Med for-løkke");
		for (int i = 0; i < tall.length; i++) {
			System.out.println(tall[i]);
		}
		System.out.println("------------");

		// Skriv ut med forbedret for-løkke
		System.out.println("Med forbedret for-løkke");
		for (int i : tall) {
			System.out.println(i);
		}
		System.out.println("------------");

		// Skriv ut med Arrays.stream().forEach:
		System.out.println("Med Arrays.stream().forEach");
		Arrays.stream(tall).forEach(System.out::println);
		System.out.println("------------");

		// Gange hvert tall med 2, sortere synkende og skrive ut resultatet
		System.out.println("Hvert tall ganger 2, sortert i synkende rekkefølge og skrevet ut med map() og forEach()");
		Arrays.stream(tall).sorted(Comparator.reverseOrder()).map(x -> x * 2).forEach(System.out::println);
		System.out.println("------------");

		// Finn største og minste verdien i et array
		// Største verdi med Arrays.stream()
		int max = Arrays.stream(tall).max(Comparator.naturalOrder()).get();
		System.out.println("Høyeste  tall: "+max);
		System.out.println("------------");

		// Minste verdi med for-løkke:
		int min = tall[0];  // min = første tall i arrayet
		for (int i = 0; i < tall.length; i++) {
			if(tall[i] < min) {   // er neste tall mindre, blir tallet det nye "min"
				min = tall[i];
			}
		}
		System.out.println("Minste tall: "+ min);
		System.out.println("------------");


		// Array med tekst
		// Lag et array for tekst-elementer med new String[<tall>]
		String[] tekst = new String[3];

		tekst[0] = "Dette er tekst 1";
		tekst[2] = "Dette er tekst 3";

		// Skriv ute arrayet med en for-løkke
		System.out.println("Tekst-array skrevet ut med en for-løkke");
		
		for (int i = 0; i < tekst.length; i++) {
			System.out.println("Element " + (i + 1) + ": " + tekst[i]);
		}

		System.out.println("-------------");
		System.out.println("Legg til tekst i element 2:");
		tekst[1] = "Dette er ny tekst i element 2";
		System.out.println(tekst[1]);

		System.out.println();

		System.out.println("Array med tillagt tekst i element 2: ");

		for (String linje : tekst) {
			System.out.println(linje);
		}

		// Skriv bare ut elementer med ordet "ny"
		System.out.println("------------");

		System.out
				.println("Skriv bare ut elementer sin inneholder ordet \"ny\" ved bruk av stream().filter().forEach()");
		Arrays.stream(tekst).filter(a -> a.contains("ny")).forEach(System.out::println);

		System.out.println("Antall elementer i tekst-Arrayet: "+Arrays.stream(tekst).count());

		// Flerdimensjonale Arrays
		// Tabell med 3 rader og 3 kollonner

		System.out.println();
		String[][] tabell = new String[3][3];

		tabell[0][0] = "Donald";
		tabell[0][1] = "Duck";
		tabell[0][2] = "donald@disney.com";

		tabell[1][0] = "Dolly";
		tabell[1][1] = "Duck";
		tabell[1][2] = "daisyd@disney.com";

		tabell[2][0] = "Petter";
		tabell[2][1] = "Smart";
		tabell[2][2] = "petter.smart@disney.com";

		// Bla gjennom med for-løkke

		System.out.println();

		System.out.println("\nTabell med for-løkke");
		System.out.println("----------------------------");

		for (int i = 0; i < tabell.length; i++) {

			System.out.println("Fornavn: " + tabell[i][0]);
			System.out.println("Etternavn: " + tabell[i][1]);
			System.out.println("Epost: " + tabell[i][2]);
			System.out.println("----------------------------");

		}

		// Bla gjennom med forbedret for-løkke

		System.out.println();

		System.out.println("\nTabell med forbedret for-løkke");
		System.out.println("----------------------------");

		for (String[] rad : tabell) {

			System.out.println("Fornavn: " + rad[0]);
			System.out.println("Etternavn: " + rad[1]);
			System.out.println("Epost: " + rad[2]);
			System.out.println("----------------------------");

		}

		// Bla gjennom med 2 forbedrede for-løkker

		System.out.println();

		System.out.println("\nTabell med to forbedrede for-løkker");
		System.out.println("--------------------------------------");

		// Skriv ut formattert utskrift med printf()
		System.out.printf("%-12s%-12s%-12s", "Fornavn", "Etternavn", "Epost");

		System.out.println();
		for (String[] rad : tabell) { // Bla gjennom rader
			for (String kollonne : rad) { // Bla gjennom kollonner
				System.out.printf("%-12s", kollonne);
			}
			System.out.println();

		}

		System.out.println("--------------------------------------");

		// Med Stream api
		// Skriv ut antall rader

		System.out.println("Antal rader i tabellen: " + Arrays.stream(tabell).count());

		// Skriv ut tabellen - tabulator-separert
		Arrays.stream(tabell).map(a -> a[0] + "\t" + a[1] + "\t" + a[2]).forEach(System.out::println);

	} // end main

} // end class
