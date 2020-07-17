package no.itfakultetet;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {

        // Hent ord fra en fil, tell opp og putt i en TreeMap, alfabetiskListe
        // Sorter etter antall ord, synkende, og lagre i en LinkedHashMap, forekomstListe

        Map<String, Long> alfabetiskListe = new TreeMap<>();
        Map<String, Long> forekomstListe = new LinkedHashMap<>();
        try {
            alfabetiskListe = Files.lines(Paths.get("war-and-peace.txt"))
                    .map(a -> a.split("[0-9!*?'\"\t.,;:() ]"))
                    .flatMap(a -> Arrays.stream(a))
                    .filter(a -> a.length() > 1 & !a.contains("CHAPTER") & !a.contains("-"))
                    .map(a -> a.toLowerCase())
                    .collect(Collectors.groupingBy(a -> a,TreeMap::new,Collectors.counting()));
            forekomstListe = alfabetiskListe.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(a, b)->a,LinkedHashMap::new));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // Skriv til fil
        try {
            FileWriter forekomstFil = new FileWriter("ord_forekomst.csv");

            skrivTilFil("ord_alfabetisk.csv",alfabetiskListe);
            skrivTilFil("ord_forekomst.csv",forekomstListe);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Metode for å skrive ordlistene til fil
    public static void skrivTilFil(String filNavn, Map<String,Long> liste ) {
        try {

            FileWriter fil = new FileWriter(filNavn);

            fil.append("Ord,Antall\n");
            liste.forEach(
                    (k, v) -> {
                        try {
                            fil.append(k + "," + v + "\n");
                        } catch (IOException e) {
                            System.out.println("Fikk ikke appended til fil fordi: "+e.getMessage() );
                            e.printStackTrace();
                        }
                    }
            );
            System.out.println(filNavn+" er lagret");
            fil.flush();
            fil.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
