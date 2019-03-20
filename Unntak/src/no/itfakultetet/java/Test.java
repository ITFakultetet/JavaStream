package no.itfakultetet.java;

import java.io.IOException;

public class Test {


	public void run(int i) throws IOException {

		if (i == 0) {
			System.out.println("Testen var vellykket!");
		} else {
			throw new IOException("Testen feilet fordi parameteret ikke var lik 0");
		}
	}

}
