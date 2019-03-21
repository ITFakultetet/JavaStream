package no.itfakultetet.java;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class App {

	public static void main(String[] args) {

		// Bruk av LocalDate

		// LocalDate.now()
		LocalDate idag = LocalDate.now();
		LocalDate imorgen = LocalDate.now().plusDays(1);
		LocalDate om3Uker = LocalDate.now().plusWeeks(3);

		System.out.println("Dato idag: " + idag);
		System.out.println("Dato imorgen: " + imorgen);
		System.out.println("Dato 3 uker fra nå: " + om3Uker);

		// lag en dato med LocalDate.of(year, month, dayOfMonth)

		LocalDate generalforsamling = LocalDate.of(2019, 2, 23);
		LocalDate utsattGeneralforsamling = generalforsamling.plusMonths(3);

		System.out.println("Generalforsamlingen utsettes fra: " + generalforsamling + " til: " + utsattGeneralforsamling);

		// Ukedag med ulike språk 
		LocalDate kursstart = LocalDate.parse("2019-03-25");
		DayOfWeek kursstartUkedag = LocalDate.parse("2019-03-25").getDayOfWeek();
		System.out.println("Course is starting: "+kursstartUkedag);
		
		// På norsk
		Locale bokmaal=new Locale("nb", "NO");
		Locale nynorsk=new Locale("nn", "NO");
	
		String kursstartNB=kursstart.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM, yyyy",bokmaal));
		String kursstartNN=kursstart.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM, yyyy",nynorsk));
		
		System.out.println("Kurset starter på : "+kursstartNB);
		System.out.println("Kurset startar på : "+kursstartNN);
		
		
		// Beregn alder ut fra fødselsdato med Period.between(startDateInclusive,
		// endDateExclusive));

		LocalDate birthDayMor = LocalDate.parse("1931-12-09");

		// Uten funksjon
		int alder = Period.between(birthDayMor, LocalDate.now()).getYears();
		int alder15Des1985 = Period.between(birthDayMor, LocalDate.of(1985, 12, 15)).getYears();
		int mndSidenAlder = Period.between(birthDayMor, LocalDate.now()).getMonths();

		// Med funksjon

		DatoTid dt1 = new DatoTid();
		int alder13nov1955 = dt1.alder(birthDayMor, LocalDate.of(1955, 11, 13));

		System.out.println("Mors alder: " + alder);
		System.out.println("Måneder siden mors bursdag: " + mndSidenAlder);
		System.out.println("Mors alder 15. desember 1985: " + alder15Des1985);
		System.out.println("Mors alder 13. november 1955: " + alder13nov1955);
		
		
	}

}
