/* 
 * BufferedReader is synchronous while Scanner is not. 
 * BufferedReader should be used if we are working with multiple threads. 
 * BufferedReader is a bit faster as compared to scanner because scanner 
 * does parsing of input data and BufferedReader simply reads sequence of characters.
*/


package no.itfakultetet.java;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
// import java.util.Scanner;

public class TelBok {

	public static void  main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		// Scanner sc = new Scanner(System.in);
		Properties bok = new Properties();
		String navn, nummer;

		try {
			FileInputStream fil = new FileInputStream("telefonbok.dat");
			bok.loadFromXML(fil);
		} catch (Exception e) {
			// do nothing
		}

		do {

			System.out.println("Legg inn navn: ( eller 'q' for å avslutte");
			// navn = sc.netxtLine();
			navn = br.readLine();
			if (navn.equals("q"))
				continue;
			System.out.println("Legg inn telefonnummer:");
			// nummer = sc.netxtLine();
			nummer = br.readLine();
			bok.put(navn, nummer);
		} while (!navn.equals("q"));

		try {

			FileOutputStream utfil = new FileOutputStream("telefonbok.dat");
			bok.storeToXML(utfil, "Telefonbok", "utf8");

		} catch (Exception e) {
			System.out.println("Kunne ikke lagre boken fordi: " + e);
		}

		// sc.close();
		br.close();
		
	}

}
