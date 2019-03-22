package no.itfakultetet.java;

import java.util.Random;

public class Tall {

	public static void main(String[] args) {

	// 10 tilfeldige terningkast	
	System.out.println("10 tilfeldige terningkast");
	for (int i = 0; i < 10; i++) {
		System.out.print(new Random().nextInt(6)+1 + " ");
	}
	
	
	}

}
