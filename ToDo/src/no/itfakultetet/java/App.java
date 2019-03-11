package no.itfakultetet.java;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		String oppgave,dato;
		Integer valg;

		do {
			System.out.println("Velg oppgave (tast inn tall - 9 for avslutt)");
			System.out.println("1. Legg inn ny oppgave");
			System.out.println("2. Vis Oppgave");
			System.out.println("3. Slett Oppgave");
			System.out.println("4. Endre Oppgave");
			System.out.println("5. List Oppgaver");
			System.out.println("9. Avslutt");

			Scanner sc1 = new Scanner(System.in);
			valg = sc1.nextInt();
			
			switch (valg) {
			case 1:
				Scanner sc2 = new Scanner(System.in);
				do {
					System.out.println("Tast inn oppgave (q for avslutt):");
					oppgave = sc1.nextLine();					
					System.out.println("Tast inn dato for opppgaven:");
					dato = sc1.nextLine();
					boolean done = false;
					Todo oppgave1 = new Todo(oppgave, dato, done);
					if (oppgave.equals("q"))
						continue;
					oppgave1.leggInn();
					System.out.println(oppgave1 + " er lagt inn");
					
				} while (!oppgave.equals("q"));
				sc2.close();
				break;
			case 2:

				break;
			case 3:

				break;

			case 4:

				break;

			case 5:

				break;

			case 9:
				break;
			}
			sc1.close();

		} while (!valg.equals(9));

	}

}
