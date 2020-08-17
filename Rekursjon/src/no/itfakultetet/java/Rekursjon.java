package no.itfakultetet.java;

import java.math.BigInteger;
import java.util.Scanner;

public class Rekursjon {

    public static void main(String[] args) {

        BigInteger f0 = new BigInteger(String.valueOf(1));
        BigInteger f1 = new BigInteger(String.valueOf(1));
        BigInteger fib = new BigInteger(String.valueOf(0));


        System.out.println("Skriv inn et tall");
        Scanner in = new Scanner(System.in);
        int tall = in.nextInt();

        long start1 = System.currentTimeMillis();
        System.out.println("Nummer "+tall+" i Fibonacci-sekvensen har verdien: "+fibonacci(tall,f0,f1,fib));
        System.out.println("Tid med rekursjon: "+(System.currentTimeMillis()-start1)+ "millis");


        long start2 = System.currentTimeMillis();
        System.out.println("Nummer "+tall+" i Fibonacci-sekvensen har verdien: "+fibonacci2(tall));
        System.out.println("Tid uten rekursjon: "+(System.currentTimeMillis()-start2)+ "millis");

        if (tall == 1) System.out.println(1);
        if (tall == 2) System.out.println(1);


    }


    private static BigInteger fibonacci(long tall, BigInteger f0, BigInteger f1, BigInteger fib){

        while(tall>0) {
            f0 = f1;
            f1 = fib;
            fib = f0.add(f1);
            // For å skrive ut alle nummerne i rekken
            // System.out.println(fib);
            fibonacci(tall--, f0,f1,fib);
        }

        return fib;
    }




    private static BigInteger fibonacci2(long tall){

        BigInteger f0;
        BigInteger f1 = new BigInteger(String.valueOf(1));
        BigInteger fib = new BigInteger(String.valueOf(0));

        for (int i=1; i<tall; i++) {
            f0 = f1;
            f1 = fib;
            fib = f0.add(f1);
            // For å skrive ut alle nummerne i rekken
            // System.out.println(fib);
        }

        return fib;
    }



}
