package no.itfakultetet;


import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {


        List<String> ord = new ArrayList<>();

        try {
            ord = Files.lines(Paths.get("war-and-peace.txt"))
                    .map(a -> a.split("[0-9!*?'\"\t.,;:() ]"))
                    .flatMap(a -> Arrays.stream(a))
                    .filter(a -> a.length() > 1 & !a.contains("CHAPTER") & !a.contains("-"))
                    .map(a -> a.toLowerCase())
                    //.limit(300)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

//        Mulig, men ikke optimalt - Collectors.gr
//        TreeMap<String,Long> ordListe = new TreeMap<>();
//
//        ord.forEach(
//                a -> {
//                    // Hvis ordet finnes på listen allerede, oppdater ordet med verdi = eksisterende verdi + 1
//                    if (ordListe.containsKey(a)) {
//                        ordListe.put(a, ordListe.get(a) + 1);
//                    } else {
//                        // Hvis ordet ikke finnes på listen, legg til ordet og sett verdien til 1
//                        ordListe.put(a, 1);
//                    }
//                }
//        );
//

        TreeMap<String, Long> ordListe = ord.stream().collect(Collectors.groupingBy(a -> a,TreeMap::new,Collectors.counting()));

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
