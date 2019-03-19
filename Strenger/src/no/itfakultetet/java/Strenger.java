package no.itfakultetet.java;

public class Strenger {

	public static void main(String[] args) {

		// Oppretting og initialisering av tekststrenger

		String tekst1;
		String tekst2 = "Dette er tekst nummer 2";
		String tekst3 = new String("Og DETTE er tekst nummer 3");
		StringBuffer tekst4 = new StringBuffer();
		StringBuffer tekst5 = new StringBuffer("Dette er tekst 5");

		// System.out.println(tekst1); Ville gitt feilmelding siden tekst1 ikke er
		// initialisert til en verdi.
		System.out.println(tekst2);
		System.out.println(tekst3);
		System.out.println(tekst4); // Gir ikke feilmelding, en tom tekstbuffer skrives til skjermen.
		System.out.println(tekst5);

		// skjøter sammen to tekststrenger og gjør om den siste til små bokstaver
		System.out.println(tekst2 + " " + tekst3.toLowerCase());

		// Mer effektiv måte å skjøte sammen tekststrenger på
		System.out.println(tekst5.append(" ").append(tekst3.toLowerCase()));
 
		tekst4.append("Nå har tekst4 innhold");
		System.out.println("\n" + tekst4);
		System.out.println("\nLengde: " + tekst4.length());
		System.out.println("Kapasitet: "+ tekst4.capacity());
		tekst4.replace(0, 2, "Da");

		System.out.println("\n" + tekst4);
		System.out.println("\nLengde: " + tekst4.length());

		
		tekst4.replace(tekst4.indexOf("Da har"), 6, "Tidligere fikk");
		
		System.out.println("\n" + tekst4);
		System.out.println("\nLengde: " + tekst4.length());

		System.out.println("Kapasiteten til tekst4: "+ tekst4.capacity());
		
		tekst4.ensureCapacity(100);
		
		System.out.println("Kapasiteten til tekst4 er økt til: "+ tekst4.capacity());
		
		tekst4.append(", og nå kan den skjøtes på med litt mer tekst");
		
		System.out.println(tekst4);
		
		
	}

}
