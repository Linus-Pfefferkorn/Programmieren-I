package demo001.simgame;

public class Arbeitsstelle {

	private String ort;
	private int anzahlArbeiter;
	
	public Arbeitsstelle(String ortBezeichnung, int mitarbeiterAnzahl) {
		
		this.ort = ortBezeichnung;
		this.anzahlArbeiter = mitarbeiterAnzahl;
	}
	
	public int getAnzahlArbeiter() {
		
		return this.anzahlArbeiter;
	}
	
	public int ArbeiterEinstellen(int anzahl) {
		
		this.anzahlArbeiter = this.anzahlArbeiter + anzahl;
		return this.anzahlArbeiter;
	}
	
	public void arbeiterEntlassen(int anzahlZuentlassender) {
		
		this.anzahlArbeiter = getAnzahlArbeiter() - anzahlZuentlassender;
	}
	
	public String getOrt() {
		
		return this.ort;
	}
	
	public String setOrt(String Standort) {
		
		this.ort = Standort;
		return this.ort;
	}
	
	
}
