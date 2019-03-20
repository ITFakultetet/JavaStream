package no.itfakultetet.java;

public class App {

	public static void main(String[] args) {

		Laptop lap1 = new Laptop(120, 43, 8);
		lap1.setProsessor("Intel i7");
		lap1.setRam("16 GB DDR3");
		lap1.setPris(8000);

		Laptop lap2 = new Laptop(120.0, 43.0, 8.0);
		lap2.setProsessor("Intel i3");
		lap2.setRam("8 GB DDR3");
		lap2.setPris(6000);
		lap2.setVekt(2.4);

		System.out.println("Laptop 1 spec: " + lap1);
		System.out.println("Laptop 2 spec: " + lap2);

	}

}
