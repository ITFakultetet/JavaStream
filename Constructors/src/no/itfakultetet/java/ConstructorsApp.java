package no.itfakultetet.java;

public class ConstructorsApp {

	public static void main(String[] args) {

		Machine maskin1 = new Machine();
		Machine maskin2 = new Machine("Petter");
		Machine maskin3 = new Machine(40);
		Machine maskin4 = new Machine("Ola",50);
		
		maskin1.setNavn("Kari");

		System.out.println("Maskin1 heter: "+maskin1.getNavn());
		System.out.println("Maskin2 heter: "+maskin2.getNavn());
		System.out.println("Maskin3 har vekt: "+maskin3.getVekt());
		System.out.println("Maskin4 heter: "+maskin4.getNavn()
		+ " og har vekt "+maskin4.getVekt());
		
		
	}

}
