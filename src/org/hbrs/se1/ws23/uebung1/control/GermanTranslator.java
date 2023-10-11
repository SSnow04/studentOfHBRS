package org.hbrs.se1.ws23.uebung1.control;

import java.text.*;
import java.util.Date;

public class GermanTranslator implements Translator {

	public String date = "Okt/2023"; // Default-Wert
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	Date datum = new Date();

	/**
	 * Methode zur Übersetzung einer Zahl in eine String-Repraesentation
	 */
	public String translateNumber( int number ) {
		// [ihr Source Code aus Übung 1-2]
		String message="";
		String[] Nums = {"eins","zwei","drei","vier","fünf","sechs","sieben","acht","neun","zehn"};
		try {
			 return Nums[number - 1];
		}catch (ArrayIndexOutOfBoundsException e){
			message = "Übersetzung der Zahl "+ number +" nicht " + "möglich ";
			printInfo();
		}
		return message;
	}

	/**
	 * Objektmethode der Klasse GermanTranslator zur Ausgabe einer Info.
	 */
	public void printInfo(){
		setDate(""+datum);
		System.out.println( "GermanTranslator v1.9, erzeugt am " + this.date );
	}

	/**
	 * Setzen des Datums, wann der Uebersetzer erzeugt wurde (Format: Monat/Jahr (Beispiel: "Okt/2022"))
	 * Das Datum sollte system-intern durch eine Control-Klasse gesetzt werden und nicht von externen View-Klassen
	 */
	public void setDate( String date ) {
		this.date = date;
	}

}
