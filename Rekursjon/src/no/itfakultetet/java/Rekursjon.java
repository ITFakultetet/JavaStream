package no.itfakultetet.java;

import java.math.BigInteger;
import java.util.Scanner;

public class Rekursjon {

    public static void main(String[] args) {

        System.out.println("Skriv inn et tall");
        Scanner in = new Scanner(System.in);
        int tall = in.nextInt();

        System.out.println("Nummer "+tall+" i Fibonacci-sekvensen har verdien: "+fibonacci(tall));


    }

    private static BigInteger fibonacci(long tall){

        if (tall == 1) return new BigInteger("1");
        if (tall == 2) return new BigInteger("1");;

        BigInteger f0;
        BigInteger f1 = new BigInteger(String.valueOf(1));
        BigInteger fib = new BigInteger(String.valueOf(0));


        for (int i=1; i<tall; i++) {
            f0 = f1;
            f1 = fib;
            fib = f0.add(f1);
            System.out.println(fib);
        }
        return fib;
    }



}
