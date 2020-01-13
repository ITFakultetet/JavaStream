package no.itfakultetet.java;

import java.util.Scanner;

public class TripPlanner {

    public static void main(String[] args) {

        intro();
        budget();
        time();

    }

    public static void intro() {

        Scanner input = new Scanner(System.in);
        System.out.println("Velkommen til ferieplanleggeren!");
        System.out.print("Hva er navnet ditt? ");
        String nameOfPlanner = input.nextLine();
        System.out.print("Hyggelig å treffe deg, " + nameOfPlanner + ". Hvor vil du reise? ");
        String travellingDestination = input.nextLine();
        System.out.println("Flott! Reise til " + travellingDestination + " høres ut som en fin tur");
        System.out.println("*****\n\n");

    }

    public static void budget() {

        Scanner input = new Scanner(System.in);
        System.out.print("Hvor mange dager bil du være borte? ");
        int noOfDays = input.nextInt();
        System.out.print("Hvor mye, i NOK, planlegger du å bruke? ");
        double amountOfMoney = input.nextDouble();
        System.out.print("Hva er trebokstavskoden for valutaen til stdet du reiser til? ");
        String symbolOfCurrency = input.next();
        System.out.print("Hvor mange " + symbolOfCurrency + " er det i 1 NOK? ");
        double multipleFactor = input.nextDouble();
        System.out.println("\n\n\n");
        System.out.println("Hvis du er borte i " + noOfDays + " dager, er det det samme som " + noOfDays * 24 + " timer, eller " + noOfDays * 24 * 60 + " minutter");
        System.out.println("Hvis du bruker " + (int) amountOfMoney + " NOK, kan du bruke " + (double) Math.round((amountOfMoney / noOfDays) * 100) / 100 + " NOK per dag");
        System.out.println("Ditt totale budsjett i " + symbolOfCurrency + " er " + amountOfMoney * multipleFactor + " " + symbolOfCurrency + ", som blir " + (double) Math.round((amountOfMoney * multipleFactor / noOfDays) * 100) / 100 + " " + symbolOfCurrency+" per dag");
        System.out.println("*****\n\n\n");

    }

    public static void time() {

        Scanner input = new Scanner(System.in);
        System.out.print("Hva er tidsforskjellen, i timer, mellom hjemstedet ditt og destinasjonen? (sett minus foran hvis det er bakover i tid) ");
        int differenceOfTime = input.nextInt();
        System.out.println("Det betyr at når det er midnatt hjemme, vil klokken være " + (24 + differenceOfTime) % 24 + ":00 på destinasjonsstedet,\nog når kl. er 12 på dagen hjemme, vil den være " + (12 + differenceOfTime) + ":00 på destinasjonsstedet");
        System.out.println("*****\n\n\n");

    }


}