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
	}

}
