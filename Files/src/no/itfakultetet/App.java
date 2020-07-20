package no.itfakultetet;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {

        // Lag to maps - en for ord sortert alfabetisk og en for ord sortert etter hvor mange ganger de forekommer
        Map<String, Long> ordAlfabetisk = new TreeMap<>();
        Map<String, Long> ordForekomst;

        //Hent filnavn/bane fra brukers input
        Scanner sc = new Scanner(System.in);
        String filNavn;
        do {
            System.out.println("Tast inn et filnavn eller \"q\" for å avslute: ");
            filNavn = sc.nextLine();
            if (filNavn.equals("q") ) {
                System.out.println("Avslutter...");
                System.exit(0);
            }
        } while (filNavn.length()==0);

        try {
            // Hent ord fra en fil, tell opp og putt i en TreeMap, ordAlfabetisk
            ordAlfabetisk = Files.lines(Paths.get(filNavn))
                    .map(a -> a.split("[0-9\\s+\\p{P}]"))
                    .flatMap(a -> Arrays.stream(a))
                    .filter(a -> a.length() > 0 & !a.contains("CHAPTER") & !a.contains("="))
                    .map(a -> a.toLowerCase())
                    .collect(Collectors.groupingBy(a -> a,TreeMap::new,Collectors.counting()));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // Sorter ordAlfabetisk etter antall ord, synkende, og lagre i en LinkedHashMap, forekomstListe
        ordForekomst = ordAlfabetisk.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,(a, b)->a,LinkedHashMap::new));

        // Skriv til fil
        // Lag et prefiks basert på filnavnet
        String fil = Paths.get(filNavn).getFileName().toString();
        String prefix = fil.substring(0,fil.indexOf("."));
        skrivTilFil(prefix+"_alfabetisk.csv",ordAlfabetisk);
        skrivTilFil(prefix+"_forekomst.csv",ordForekomst);

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
