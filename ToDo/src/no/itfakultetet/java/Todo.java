package no.itfakultetet.java;

import java.util.Date;

public class Todo {

	private String oppgave;
	private String dato;
	private boolean done;

	public Todo(String oppgave, String dato2, boolean done) {
		super();
		this.oppgave = oppgave;
		this.dato = dato2;
		this.done = done;
	}

	@Override
	public String toString() {
		return "Todo [oppgave=" + oppgave + ", dato=" + dato + ", done=" + done + "]";
	}

	public void leggInn() {
		System.out.println("Legger inn ny oppgave");
		
	}

	public void oppdater() {
		System.out.println("Oppdaterer oppgave");
	}

	public void slett() {
		System.out.println("Sletter oppgave");
	}

	public void finn() {
		System.out.println("Søker etter oppgave");
	}

	public void listUt() {

	}

	public String getOppgave() {
		return oppgave;
	}

	public void setOppgave(String oppgave) {
		this.oppgave = oppgave;
	}

	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dato == null) ? 0 : dato.hashCode());
		result = prime * result + (done ? 1231 : 1237);
		result = prime * result + ((oppgave == null) ? 0 : oppgave.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if (dato == null) {
			if (other.dato != null)
				return false;
		} else if (!dato.equals(other.dato))
			return false;
		if (done != other.done)
			return false;
		if (oppgave == null) {
			if (other.oppgave != null)
				return false;
		} else if (!oppgave.equals(other.oppgave))
			return false;
		return true;
	}

}
