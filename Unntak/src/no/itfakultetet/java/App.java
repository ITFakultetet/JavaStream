package no.itfakultetet.java;

import java.io.IOException;

public class App {

	public static void main(String[] args) {

		Test test1 = new Test();
		
		try {
			test1.run(0);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		try {
			test1.run(1);
		} catch (IOException e) {
			// System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

}
