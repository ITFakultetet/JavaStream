package no.itfakultetet.java;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapDemo {

	public static void main(String[] args) {

		HashMap<Integer, String> map1 = new HashMap<>();

		map1.put(6, "Nummer 6");
		map1.put(1, "Nummer 1");
		map1.put(11,"Nummer 11");
		map1.put(3, "Nummer 3");
		map1.put(2, "Nummer 2");
		map1.put(12, "Nummer 12");

		// Hent verdien til nøkkel 1
		System.out.println(map1.get(1));

		// Print ut toString() for map1
		System.out.println(map1);
		
		// Print ut et linjeskift
		System.out.println();

		
		// Gammel måte å bla gjennom en map

		for(int key: map1.keySet()) {
			System.out.println(key+ " : " + map1.get(key));
		}
		
		// Ny, enklere måte å bla gjennom en map på med lambda-funkasjon
		map1.forEach((k, v) -> System.out.println(k + " - " + v));

		
		
		
	}

}
