package no.itfakultetet.java;

public class App {

    public static void main(String[] args) {

        // Lag en ny plante
        Plante plante = new Plante();
        plante.gro();
        plante.mist_blader();

        // Lag en ny kaktus
        Kaktus kaktus = new Kaktus();
        kaktus.gro();
        kaktus.mist_blader();

        // Lag en Plante som er en referanse til en kaktus
        Plante kaktus2 = kaktus;
        Plante kaktus3 = new Kaktus();

        // Hvilken klasse er kaktus
        System.out.println("kaktus har denne klassen: " + kaktus.getClass());
        System.out.println("kaktus2 har denne klassen: " + kaktus2.getClass());
        System.out.println("kaktus3 har denne klassen: "+ kaktus3.getClass());

        System.out.println("kaktus2 har denne arten: " + kaktus2.getArt());
        System.out.println("kaktus3 har denne arten: " + kaktus3.getArt());

        kaktus2.gro();
        kaktus2.mist_blader();

        kaktus3.gro();
        kaktus3.mist_blader();


    }

}
