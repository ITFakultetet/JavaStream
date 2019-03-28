package no.itfakultetet;

import java.util.Map;

public class App {
	/**
	 * 
	 * @param args
	 *            Filnavn fra kommandolinjen
	 */
	public static void main(String[] args) {

		// Sjekk at det gis ett argument til programmet eller opplys om bruken
		
		if (args.length != 1) {
			System.out.println("Bruk: java -Jar ord.jar <tekstfil>");
			System.exit(0);
		}

		
		// Hent filnavnet fra kommandolinjens første argument (det første vi
		// skriver inn) og lagre filnavnet i variablen fil

		String fil = args[0];

		// Instansier et Ord-objekt
		Ord ord = new Ord();
		
		ord.setFil(fil);
		
		// Les inn filen fra argumentet til programmet og gi en melding om at vi behandler filen
		System.out.println("Behandler filen: " + ord.getFil());
		
		// start en tidtaker
		Long start = System.currentTimeMillis();
		ord.setUtfil1("ord_" + fil);
		ord.setUtfil2("antall_" + fil);
		
		// Lag to Maps hvor vi kan mellomlagre ordene i tekstfilen vi leser inn 
		Map<String, Integer> tre = ord.lesFil(ord.getFil());
		Map<String, Integer> sortert = ord.sorterFil(tre);
	
		// Skriv fil med ord i alfabetisk orden
		ord.skrivfil(ord.getUtfil1(), tre);
		
		// Skriv fil med ord sortert etter antall
		ord.skrivfil(ord.getUtfil2(), sortert);

		Long stop = System.currentTimeMillis();
		Double tid = (stop-start)/1000.0;
		
		System.out.println("Filen "+ord.getFil()+" inneholder "+tre.size()+" unike ord.");
		System.out.println("De 10 ordene som forekommer hyppigst er: ");
		sortert.entrySet().stream().limit(10).forEach(k-> System.out.print(k+" "));
		System.out.println();
		System.out.println("Filene "+ord.getUtfil1()+" og "+ord.getUtfil2()+" ble skrevet på "+tid+" sekunder");
	}
	

}
