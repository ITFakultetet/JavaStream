package no.itfakultetet.java;

public class App {

    public static void main(String[] args) {


        Kaktus kaktus = new Kaktus();
        kaktus.gro();

        Plante plante = new Plante();
        plante.gro();

        Plante kaktus2 = kaktus;

        System.out.println(kaktus.getClass());

        System.out.println(kaktus2.getArt());

        kaktus2.gro();
        kaktus2.mist_blader();

    }

}
