package no.itfakultetet;


import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        // Hent ord fra fil, tell opp og putt i en TreeMap

        TreeMap<String, Long> ordListe = new TreeMap<>();
        try {
            ordListe = Files.lines(Paths.get("war-and-peace.txt"))
                    .map(a -> a.split("[0-9!*?'\"\t.,;:() ]"))
                    .flatMap(a -> Arrays.stream(a))
                    .filter(a -> a.length() > 1 & !a.contains("CHAPTER") & !a.contains("-"))
                    .map(a -> a.toLowerCase())
                    .collect(Collectors.groupingBy(a -> a,TreeMap::new,Collectors.counting()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Skriv til fil
        try {
            FileWriter alfabetiskFil = new FileWriter("ord_alfabetisk.csv");

            try {
                alfabetiskFil.append("Ord,Antall\n");
                ordListe.forEach(
                        (k, v) -> {
                            try {
                                alfabetiskFil.append(k + "," + v + "\n");
                            } catch (IOException e) {
                                System.out.println("Fikk ikke appended til fil fordi: "+e.getMessage() );
                                e.printStackTrace();
                            }
                        }
                );
            } catch (IOException e) {
                e.printStackTrace();
            }

            alfabetiskFil.flush();
            alfabetiskFil.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
