package demo001.simgame;

public class Arbeitsstelle {

	private String ort;
	private int anzahlArbeiter;
	private int lohn;

	public Arbeitsstelle(String ortBezeichnung, int mitarbeiterAnzahl, int lohnhoehe) {

		this.ort = ortBezeichnung;
		this.anzahlArbeiter = mitarbeiterAnzahl;
		this.lohn = lohnhoehe;
	}

	public int getAnzahlArbeiter() {

		return this.anzahlArbeiter;
	}

	public int ArbeiterEinstellen(int anzahl) {

		this.anzahlArbeiter = this.anzahlArbeiter + anzahl;
		return this.anzahlArbeiter;
	}

	public void arbeiterEntlassen(int anzahlZuentlassender) {
		
		if (anzahlZuentlassender < getAnzahlArbeiter()) {
			this.anzahlArbeiter = getAnzahlArbeiter() - anzahlZuentlassender;			
		}
		else {
			this.anzahlArbeiter = 0;
		}

		
	}
	
	public int getLohn() {
		return this.lohn;		
	}
	
	public void setLohnerhoehung(int erhoehung) {
		
		this.lohn = this.lohn + erhoehung;
	}
	
	public void setLohnsenkung(int senkung) {
		
		this.lohn = this.getLohn() - senkung;
	}

	public String getOrt() {

		return this.ort;
	}
	
	public int getGesamtlohn() {
		
		int gesamtlohn = getLohn() * getAnzahlArbeiter();
		return gesamtlohn;
	}

	public String setOrt(String Standort) {

		this.ort = Standort;
		return this.ort;
	}

}
