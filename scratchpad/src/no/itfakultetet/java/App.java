package no.itfakultetet.java;

import java.util.*;

public class App {

    public static void main(String[] args) {


        Map<String, Integer> dyr = Map.of("Dagros",10,"Litago",4);
        System.out.println(dyr.getClass());

        dyr.forEach((k,v) -> System.out.println(k+ " er "+ v+ " år gammel"));


        Map<String,Integer> dyr2 = new HashMap<>();

        System.out.println(dyr2.getClass());

        dyr2.putAll(dyr);
        dyr2.put("Pan",3);

        dyr2.forEach((k,v) -> System.out.println(k+ " er "+ v+ " år gammel"));


        Ansatt helge = new Ansatt("Helge Pettersen",28,"M");
        Ansatt olga = new Ansatt("Olga Olsen",37,"K");
        Ansatt hans = new Ansatt("Hans Pettersen",34,"M");

        System.out.println(helge.getNavn());

        Map<Integer, Ansatt> ansatte = Map.of(1,helge,2,olga,3,hans);

        Map<Integer, Ansatt> ansatte_original = new LinkedHashMap<>();
        ansatte_original.put(2,olga);
        ansatte_original.put(1,helge);
        ansatte_original.put(3,hans);

        Map<Integer, Ansatt> ansatte_sortert = new TreeMap<>();
        ansatte_sortert.putAll(ansatte);

        System.out.println("Sortert etter nøkkel");
        ansatte.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach((k)-> System.out.println("ID: "+k.getKey()+" Navn: "+k.getValue().getNavn() ));

        System.out.println("Sortert etter navn");
        ansatte.entrySet().stream().sorted(Map.Entry.comparingByValue((a,b)-> a.getNavn().compareTo(b.getNavn()))).forEach((k)-> System.out.println("ID: "+k.getKey()+" Navn: "+k.getValue().getNavn() ));

        System.out.println("Sortert etter alder");
        ansatte.entrySet().stream().sorted(Map.Entry.comparingByValue((a,b)-> a.getAlder().compareTo(b.getAlder()))).forEach((k)-> System.out.println("ID: "+k.getKey()+" Navn: "+k.getValue().getNavn()+" Alder: "+k.getValue().getAlder() ));


        // ansatte_original.forEach((k,v)-> System.out.println("ID: "+k+" Navn: "+v.getNavn() ));
        System.out.println("Sortert etter nøkkel med TreeMap");
        ansatte_sortert.forEach((k,v)-> System.out.println("ID: "+k+" Navn: "+v.getNavn() ));


    }




}
