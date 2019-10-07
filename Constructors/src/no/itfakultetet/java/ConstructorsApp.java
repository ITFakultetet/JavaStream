package no.itfakultetet.java;

public class ConstructorsApp {

	public static void main(String[] args) {

		Machine maskin1 = new Machine();
		System.out.println("----------");
		Machine maskin2 = new Machine("Petter");
		System.out.println("----------");
		Machine maskin3 = new Machine(40);
		System.out.println("----------");
		Machine maskin4 = new Machine("Bobcat",4500);
		System.out.println("----------");
		 
		maskin1.setNavn("Kari");

		System.out.println("Maskin1 er en "+maskin1.getType() +" som heter: "+maskin1.getNavn());
		System.out.println("Maskin2 heter: "+maskin2.getNavn());
		System.out.println("Maskin3 har vekt: "+maskin3.getVekt());
		
		maskin4.setType("Liten gravemaskin");
		
		System.out.println("Maskin4 heter: "+maskin4.getNavn()
		+ " og har vekt "+maskin4.getVekt()+"kg og er en "+maskin4.getType());
		
		
	}

}
