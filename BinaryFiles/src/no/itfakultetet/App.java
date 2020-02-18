package no.itfakultetet;

import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException {


        // Meny

        System.out.println("Tast inn valg:");
        System.out.println("1 - Legg inn nytt kurs");
        System.out.println("2 - List ut kurs");
        System.out.println("0 - Avslutt");

        BinFile fil = new BinFile("kurs.dat");

        Scanner sc0 = new Scanner(System.in);
        Integer valg = sc0.nextInt();

        switch (valg) {
            case 1:
                Scanner sc1 = new Scanner(System.in);
                System.out.println("Kurstittel: ");
                String tittel = sc1.nextLine();
                System.out.println("Start-dato (YYYY-MM-DD): ");
                String startDato = sc1.nextLine();
                System.out.println("Slutt-dato (YYYY-MM-DD): ");
                String sluttDato = sc1.nextLine();
                System.out.println("Deltakere: ");
                int deltakere = sc1.nextInt();
                System.out.println("Fakturert: ");
                int fakturert = sc1.nextInt();

                fil.writeFile(tittel, startDato, sluttDato, deltakere, fakturert);
                sc1.close();
                break;
            case 2:
                fil.readFile("kurs.dat");
                break;
            case 0:
                System.out.println("Farvel...");
                System.exit(0);

        }


    }
}
