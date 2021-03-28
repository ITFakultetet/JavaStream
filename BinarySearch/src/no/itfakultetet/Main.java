package no.itfakultetet;

import org.w3c.dom.ls.LSOutput;

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

        Integer finn = 1234567;
        Long start = System.currentTimeMillis();
        System.out.println("Tallet " + finn + " er på posisjon: " + binSearch(tall, finn));
        Long stopp = System.currentTimeMillis();
        System.out.println("Tid med binærsøk = "+(stopp-start)+ " millis.");

        Long start2 = System.currentTimeMillis();
        System.out.println("-".repeat(40));
        for (int j = 0; j < tall.size(); j++) {
            if (finn.equals(tall.get(j))) {
                System.out.println("Tallet " + finn + " er på posisjon: "+j);
                break;
            }
        }
        Long stopp2 = System.currentTimeMillis();

        System.out.println("Tid med for-løkke = "+(stopp2-start2)+ " millis.");
        System.out.println("-".repeat(40));
        Long start3 = System.currentTimeMillis();

            System.out.println("Tallet "+finn+" ble funnet på posisjon "+tall.indexOf(finn));
            System.out.println("Tid med indexOf() = "+(System.currentTimeMillis()-start3)+ " millis.");

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
        return low -1;
    }


} // end class



