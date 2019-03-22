package no.itfakultetet.java;

import java.util.Random;

public class Tall {

	public static void main(String[] args) {

		// Noen tall å jobbe med:

		double tall1 = 34.2356;
		int tall2 = 6;
		float tall3 = 3.67f;
		
		// Avrunding av tall

		System.out.println("Tall1 = " + tall1);
		System.out.println("Tall1 avrundet til heltall = " + Math.round(tall1));
		System.out.println("Tall1 avrundet til to desimaler = " + Math.round(tall1 * 100) / 100.0);

		System.out.println();

		// Potenser og røtter
		
		System.out.println("6 i 3 potens: "+ Math.pow(tall2, 3));
		System.out.println("Kvadratroten av 90: "+ Math.sqrt(90));
		System.out.println("Høyeste tall av "+tall1+" og "+tall2+": "+ Math.max(tall1, tall2));
		System.out.println("Minste tall av "+tall3+" og "+tall2+": "+ Math.min(tall3, tall2));
		

		// Tilfeldige tall

		// Bruk av Math.random()
		// til å lage tilfeldige desimaltall mellom 0 og 1;

		
		System.out.println("\n5 tilfeldige tall: ");

		for (int i = 0; i < 5; i++) {
			System.out.println(Math.random());
		}

		// Bruk av java.util.Random
		// 10 tilfeldige terningkast
		System.out.println("\n10 tilfeldige terningkast");
		for (int i = 0; i < 10; i++) {
			System.out.print(new Random().nextInt(6) + 1 + " ");
		}

	}

}