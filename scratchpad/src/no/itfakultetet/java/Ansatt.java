package no.itfakultetet.java;

public class Ansatt {

private String navn;
private Integer alder;
private String kjønn;


    public Ansatt() {

    }

    public Ansatt(String navn, Integer alder, String kjønn) {
        this.navn = navn;
        this.alder = alder;
        this.kjønn = kjønn;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public Integer getAlder() {
        return alder;
    }

    public void setAlder(Integer alder) {
        this.alder = alder;
    }

    public String getKjønn() {
        return kjønn;
    }

    public void setKjønn(String kjønn) {
        this.kjønn = kjønn;
    }
}
