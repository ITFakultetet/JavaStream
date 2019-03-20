package no.itfakultetet.java;

public class Maskin {

	double vekt;
	double lengde;
	double bredde;
	double tykkelse;
	double pris;
	int alder;
	
	public Maskin(double vekt, double lengde, double bredde, double tykkelse, double pris, int alder) {
		super();
		this.vekt = vekt;
		this.lengde = lengde;
		this.bredde = bredde;
		this.tykkelse = tykkelse;
		this.pris = pris;
		this.alder = alder;
	}

	public Maskin(double vekt, double lengde, double bredde, double tykkelse) {
		super();
		this.vekt = vekt;
		this.lengde = lengde;
		this.bredde = bredde;
		this.tykkelse = tykkelse;
	}

	public Maskin(double lengde, double bredde, double tykkelse) {
		super();
		this.lengde = lengde;
		this.bredde = bredde;
		this.tykkelse = tykkelse;
	}

	public Maskin(double pris, int alder) {
		super();
		this.pris = pris;
		this.alder = alder;
	}

	public double getVekt() {
		return vekt;
	}

	public void setVekt(double vekt) {
		this.vekt = vekt;
	}

	public double getLengde() {
		return lengde;
	}

	public void setLengde(double lengde) {
		this.lengde = lengde;
	}

	public double getBredde() {
		return bredde;
	}

	public void setBredde(double bredde) {
		this.bredde = bredde;
	}

	public double getTykkelse() {
		return tykkelse;
	}

	public void setTykkelse(double tykkelse) {
		this.tykkelse = tykkelse;
	}

	public double getPris() {
		return pris;
	}

	public void setPris(double pris) {
		this.pris = pris;
	}

	public int getAlder() {
		return alder;
	}

	public void setAlder(int alder) { 
		this.alder = alder;
	}
	
	
	// Metoder
	
	public void start() {
		System.out.println("Maskin startet...");
	}
	

	public void stopp() {
		System.out.println("Maskin stoppet...");
	}


	public void pause() {
		System.out.println("Maskin er satt i pause...");
	}

	
	
}
