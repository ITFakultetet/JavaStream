package no.itfakultetet;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> tall = new ArrayList<>();

        for (int i = 0; i < 1E7+5; i +=5) {
            tall.add(i);
        }

        System.out.println(tall.size());
        System.out.println(tall.get(0) + " - " + tall.get(tall.size() - 1));

        Integer finn = 7710;
        System.out.println("Tallet " + finn + " er på posisjon: " + binSearch(tall, finn));

        //tall.forEach(System.out::println);
    }


    public static Integer binSearch(List<Integer> liste, Integer tall) {
        int i = 0;
        Integer low = 0;
        Integer high = liste.size() - 1;

        while (high >= low) {
            Integer mid = (low + high) / 2;
            if (tall < liste.get(mid))
                high = mid - 1;
            else if (tall.equals(liste.get(mid))) {
                System.out.println("Gjennomført med " + i + " itereringer.");
                return mid;
            } else
                low = mid + 1;
            i++;
        }

        System.out.println("Gjennomført med "+i+" itereringer.");
        return -low -1;
    }


} // end class



