package demo001;

import java.util.*;

public class Fuehrungskraft {

	private int MitArbID;
	private String Arbeitsbezeichnung;
	private String abteilung;
	private int gehalt;
	private int anzahlunterstellter = 0;

	private ArrayList<Arbeitskraft> Arbeiter = new ArrayList<Arbeitskraft>();

	public Fuehrungskraft(int MA_ID, String titel, int gehalt) {

		this.MitArbID = MA_ID;
		this.Arbeitsbezeichnung = titel;
		this.gehalt = gehalt;
	}

	public void bezeichnungAendern(String bezeichnung) {

		this.Arbeitsbezeichnung = bezeichnung;
	}

	public void einerabteilungZuweisen(String abteilung) {

		this.abteilung = abteilung;
	}

	public void gehaltAnpassen(int aenderung) {

		this.gehalt = gehalt + aenderung;
	}

	public void anzahlunterstellterAnpassen() {

		this.anzahlunterstellter = anzahlunterstellter + 1;
	}

	public void arbeitskraftUnterstellen(Arbeitskraft arbeiter) {

		Arbeiter.add(arbeiter);
		arbeiter.leiterZuweisen(this);
		anzahlunterstellterAnpassen();
	}

}
