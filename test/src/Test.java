import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

        Long start = System.currentTimeMillis();
        List<String> ord = new ArrayList<>();
        try {
            ord = Files.lines(Paths.get("/home/terje/Nedlastinger/war-and-peace.txt"))
                    .map(a -> a.split("[0-9?=#/\t()*.,;:! '\n\r{}\" --]"))
                    .flatMap(a -> Arrays.stream(a))
                    .filter(a -> a.length() > 0)
                    .map(a -> a.toLowerCase())
                    //.limit(200)
                    .collect(Collectors.toList());

//            ord.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

        TreeMap<String, Integer> ordListe = new TreeMap<>();

        ord.forEach(
                a -> {
                    Integer en = ordListe.containsKey(a) ?
                            ordListe.put(a, ordListe.get(a) + 1) :
                            ordListe.put(a, 1);
                }
        );


        // System.out.println(ordListe);

        try {
            FileWriter sortertFil = new FileWriter("ord_alfabetisk.csv");
            sortertFil.append("Ord,Antall\n");
            ordListe.forEach(
                    (k, v) -> {
                        try {
                            sortertFil.append(k + "," + v + "\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
            );

            sortertFil.flush();
            sortertFil.close();


            FileWriter etterAntallFil = new FileWriter("ord_antall.csv");
            etterAntallFil.append("Ord,Antall\n");

            ordListe.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEach(
                    a -> {
                        try {
                            etterAntallFil.append(a.getKey() + "," + a.getValue() + "\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
            );


        } catch (IOException e) {
            e.printStackTrace();
        }

        Long end = System.currentTimeMillis();
        System.out.println("Tid: " + (end - start));

    }


}
