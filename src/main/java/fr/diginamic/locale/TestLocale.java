package fr.diginamic.locale;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;


public class TestLocale {
	public static void main(String[] args) {
		LocalDate 			date = LocalDate.now();
		Double              nbr = 123.456D;
		
		DateTimeFormatter	formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		
		DecimalFormat nbrFormatter = new DecimalFormat();
		
		System.out.println( date.format(formatter));
		System.out.println( Locale.getDefault());
		System.out.println( nbrFormatter.format( nbr));
	}
}
