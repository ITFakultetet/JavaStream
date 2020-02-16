package no.itfakultetet;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {


        BinFile fil = new BinFile("kurs.dat");
        fil.writeFile("SQL Grunnkurs","2020-02-10",34000);


        fil.readFile("kurs.dat");

    }
}
