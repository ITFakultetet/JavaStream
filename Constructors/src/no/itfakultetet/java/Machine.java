package no.itfakultetet.java;

public class Machine {

	private String navn;
	private Integer vekt;
	private String type; 

	public Machine() {
		System.out.println("Constructor 1 ble kalt");
		this.setType("Maskin");
	}

	public Machine(String navn) {
		this();
		this.navn = navn;
		System.out.println("Constructor 2 ble kalt");
	}

	public Machine(Integer vekt) {
		this();
		this.vekt = vekt;
		System.out.println("Constructor 3 ble kalt");
	}

	public Machine(String navn, Integer vekt) {
		this();
		this.navn = navn;
		this.vekt = vekt;
		System.out.println("Constructor 4 ble kalt");
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public Integer getVekt() {
		return vekt;
	}

	public void setVekt(Integer vekt) {
		this.vekt = vekt;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
	
}
