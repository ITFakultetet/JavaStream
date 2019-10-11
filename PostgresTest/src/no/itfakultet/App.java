package no.itfakultet;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Data data = new Data();
        String navn = "";
        Scanner sc1 = new Scanner(System.in);

        while (true) {
            System.out.println("Skriv inn starten på firmanavnet (eller q for avslutt)");
            navn = sc1.nextLine();
            if (navn.equals("q")) break;
            data.getData(navn);
        } // end while

        System.out.println("Farvel...");
        sc1.close();
        System.exit(0);

    } // end main
} // end class
