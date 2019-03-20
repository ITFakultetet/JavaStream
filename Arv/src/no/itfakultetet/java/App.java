package no.itfakultetet.java;

public class App {

	public static void main(String[] args) {

		Laptop lap1 = new Laptop(120, 43, 8);
		lap1.setProsessor("Intel i7");
		lap1.setRam("16 GB DDR3");
		
		lap1.setPris(8000);
		

		System.out.println("Laptop 1 spec: "+lap1);
		
	}

}
