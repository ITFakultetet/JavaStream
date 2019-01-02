package no.itfakultetet;

import java.util.Map;

public class App {
	/**
	 * 
	 * @param args
	 *            Filnavn fra kommandolinjen
	 */
	public static void main(String[] args) {

		// Hent filnavnet fra kommandolinjens første argument (det første vi
		// skriver inn) og lagre filnavnet i variablen fil

		if (args.length != 1) {
			System.out.println("Bruk: java -Jar Ord.jar <tekstfil>");
			System.exit(0);
		}

		String fil;
		fil = args[0];

		Ord ord = new Ord();
		ord.setFil(fil);
		System.out.println("Behandler " + ord.getFil());
		Long start = System.currentTimeMillis();
		ord.setUtfil1("ord_" + fil);
		ord.setUtfil2("antall_" + fil);

		Map<String, Integer> tre = ord.lesFil(ord.getFil());
		Map<String, Integer> sortert = ord.sorterFil(tre);
	
		// Skriv fil med ord i alfabetisk orden
		ord.skrivfil(ord.getUtfil1(), tre);
		// Skriv fil med ord sortert etter antall
		ord.skrivfil(ord.getUtfil2(), sortert);

		Long stop = System.currentTimeMillis();
		Double tid = (stop-start)/1000.0;
		System.out.println("Filene "+ord.getUtfil1()+" og "+ord.getUtfil2()+" ble skrevet på "+tid+" sekunder");
	}

}
