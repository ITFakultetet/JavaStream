package no.itfakultetet;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {


        BinFile fil = new BinFile("terje2.dat");
        fil.writeFile("Dette er en tekst til");
        fil.writeFile("Dette er en ny linje");

        fil.readFile("terje2.dat");

    }
}
