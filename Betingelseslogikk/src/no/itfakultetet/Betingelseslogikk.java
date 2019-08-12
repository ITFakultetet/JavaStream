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

		String resultat = a < 50 ? a + " er mindre enn 50" : a + " er ikke mindre enn 50";
		System.out.println(resultat);

		// Switch før Java 12

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
		case 60:
			System.out.println(a + " er 50");
			break;
		default:
			System.out.println(a + " er større enn 50");
			break;
		}

		System.out.println("Med ny switch:");
		a = 30;

		System.out.println(a + " er " + tallet(a));
		a = 14;
		System.out.println(a + " er " + tallet(a));

	}

	// Switch fra og med Java 12
	final static String tallet(int tall) {

		@SuppressWarnings("preview")
		var setning = switch (tall) {
		case 1, 2, 3, 4, 5, 6, 7, 8, 9 -> "mindre enn 10";
		case 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 -> "mellom 10 og 20";
		default -> "større enn 20";
		};

		return setning;

	}

}
