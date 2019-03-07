package no.itfakultetet;

public class Betingelseslogikk {

	public static void main(String[] args) {

		// If-then-else
		Integer a = 40;

		if (a < 20) {
			System.out.println(a + " er mindre enn 20");
		} else {
			System.out.println(a + " er ikke mindre enn 20");
		}

		// ternary operator

		String resulat = a < 50 ? a + " er mindre enn 50" : a + " er ikke mindre enn 50";
		System.out.println(resulat);

		// Switch
		
		switch (a) {
		case 10:
			System.out.println(a + " er 10");
			break;
		case 20:
			System.out.println(a + " er 20");
			break;
		case 30:
			System.out.println(a + " er 30");
			break;	
		case 40:
			System.out.println(a + " er 40");
			break;
		case 60 :
			System.out.println(a + " er 50");
			break;	
		default:
			System.out.println(a + " er større enn 50");
			break;
		}
	
	
	}

}
