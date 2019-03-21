package no.itfakultetet.java;

import java.time.LocalDate;
import java.time.Period;

public class DatoTid {

	public int alder(LocalDate birthDate, LocalDate currentDate) {

		return Period.between(birthDate, currentDate).getYears();

	}

	
	
	
	
}
