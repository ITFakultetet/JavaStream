package no.itfakultetet.java;

import java.util.Set;

public class Sets {

	public static void main(String[] args) {
	
		
	Set<Integer> sett1 = Set.of(2,8,5,9);
	Set<String> sett2 = Set.of("Oskar", "Kari","Nils","Eva");

	System.out.println(sett1);
	System.out.println(sett2);		

	// Skriv ut Kari
	sett2.stream().filter(a -> a.contains("Kari")).forEach(System.out::print);
	
	
	}

}
