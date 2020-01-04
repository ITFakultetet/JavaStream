package no.itfakultetet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Lite program som teller antall ord i en tekstfil og lagrer to filer, en
 * sortert alfabetisk og en sortert etter antall forekomster
 * 
 * Lager en TreeMap - tre1 - og putter ordene i den ved først å lage en
 * Buffer,så lese inn linje for linje fra filen i bufferen, splitte linjen opp i
 * ord, konvertere til små bokstaver og putte dem inn i tre1, hvis de ikke
 * finnes der fra før, for da øker vi antallet med 1 isteden.
 *
 * @author Terje Berg-Hansen
 * @version 1.0
 */

public class Ord {

	String fil, utfil1, utfil2;

	public String getFil() {
		return fil;
	}
	public void setFil(String fil) {
		this.fil = fil;
	}
	public String getUtfil1() {
		return utfil1;
	}
	public void setUtfil1(String utfil1) {
		this.utfil1 = utfil1;
	}
	public String getUtfil2() {
		return utfil2;
	}
	public void setUtfil2(String utfil2) {
		this.utfil2 = utfil2;
	}

	public Ord() {

	}

	// Metode for å lese en fil inn i en TreeMap hvor ord kan telles opp
	public Map<String, Integer> lesFil(String fil) {

		TreeMap<String, Integer> tre1 = new TreeMap<>();

		try (BufferedReader br = new BufferedReader(new FileReader(fil))) {

			String input;

			while ((input = br.readLine()) != null) {

				String ord[] = input.split("[?\t()*.,;:!'\n\r{}” ]");

				for (int i = 0; i < ord.length; i++) {

					if (!ord[i].isEmpty()) {
						ord[i] = ord[i].toLowerCase();
						if (tre1.containsKey(ord[i])) {
							tre1.put(ord[i], tre1.get(ord[i]) + 1);
						} else {
							tre1.put(ord[i], 1);
						}
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return tre1;

	}

	// Metode for å sortere etter antall
	public Map<String, Integer> sorterFil(Map<String, Integer> tre2) {

		// Sortere tre2 etter antall (istedenfor etter ord alfabetisk)
		Map<String, Integer> sortertMap = new LinkedHashMap<>();

		tre2.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
				.forEachOrdered(x -> sortertMap.put(x.getKey(), x.getValue()));

		return sortertMap;

	}

	// Metode for å skrive filer
	public void skrivfil(String utfil, Map<String, Integer> tre) {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(utfil))) {

			bw.write("ord,antall\n");
			tre.forEach((k, v) -> {
				try {
					if (!k.matches("[0-9].*") && !k.isEmpty()) {
						bw.write("\"" + k + "\"" + "," + v + "\n");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end skrivfil

}
