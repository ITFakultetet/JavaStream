package no.itfakultetet.java;

public class Plante {

    private String art = "Plante";

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public void gro() {
        System.out.println(getArt() + " gror...");
    }

    public void mist_blader() {
        System.out.println(art + " mister bladene...");
    }

}
