package no.itfakultetet;

public class Arrays {

	public static void main(String[] args) {

		int[] tall = { 12, 34, 2, 67 };

		for (int i = 0; i < tall.length; i++) {
			System.out.println(tall[i]);
		}

		String[] tekst = new String[3];
		tekst[0] = "Dette er tekst 1";
		tekst[2] = "Dette er tekst 3";

		for (int i = 0; i < tekst.length; i++) {
			System.out.println("Element "+(i+1)+": "+tekst[i]);
		}

//		System.out.println(tekst.toString());
		
		tekst[1] = "Dette er ny tekst i element 2";
		
		System.out.println(tekst[1]);
		
		// Flerdimensjonale Arrays
		// Tabell med 10 rader og 3 kollonner
		String[][] tabell = new String[3][10];
		
		tabell[0][0] = "Donald";
		tabell[0][1] = "Duck";
		tabell[0][2] = "donald@disney.com";
		
		tabell[1][0] = "Dolly";
		tabell[1][1] = "Duck";
		tabell[1][2] = "daisyd@disney.com";
		
		tabell[2][0] = "Petter";
		tabell[2][1] = "Smart";
		tabell[2][2] = "petter.smart@disney.com";
		
		
		System.out.println("\nTabell");
		System.out.println("----------------------------");
		
		for (int i = 0; i < tabell.length; i++) {
			
			System.out.println("Fornavn: "+tabell[i][0]);
			System.out.println("Etternavn: "+tabell[i][1]);
			System.out.println("Epost: "+tabell[i][2]);
			System.out.println("----------------------------");
			
		}
		
		
		
		
		
				
		
		
		

	}

}
