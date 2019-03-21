package no.itfakultetet.java;

import java.io.IOException;

public class Test {


	public void run(int i) throws IOException {
		// Test at argumentet er lik 0, hvis ikke gi feilmelding
		if (i == 0) {
			System.out.println("Testen var vellykket!");
		} else {
			throw new IOException("Testen feilet fordi parameteret var tallet \""+ i +"\" og ikke tallet 0");
		}
	}
 
	
	public void run(String i) throws IOException {
		// Test at argumentet er lik 0, hvis ikke gi feilmelding
		if (i == "0") {
			System.out.println("Testen var vellykket!");
		} else {
			throw new IOException("Testen feilet fordi parameteret var teksten \"" + i + "\" og ikke tallet 0");
		}
	}
	
	
}
