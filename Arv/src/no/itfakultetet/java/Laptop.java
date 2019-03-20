package no.itfakultetet.java;

public class Laptop extends Maskin {

	String prosessor;
	String ram;
	
	public Laptop(double lengde, double bredde, double tykkelse) {
		super(lengde, bredde, tykkelse);
		// TODO Auto-generated constructor stub
	}

	public String getProsessor() {
		return prosessor;
	}

	public void setProsessor(String prosessor) {
		this.prosessor = prosessor;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	@Override
	public String toString() {
		return "Laptop [prosessor=" + prosessor + ", ram=" + ram + ", vekt=" + vekt + ", lengde=" + lengde + ", bredde="
				+ bredde + ", tykkelse=" + tykkelse + ", pris=" + pris + ", alder=" + alder + "]";
	}
	
	
	
	
}
