package demo001;
import java.util.*;

public class Gebaeude {

	private String Adresse;
	private int RaumAnzahl;
	
	private ArrayList<Raum> raumliste = new ArrayList<Raum>();
	
	public Gebaeude(String Adresse, int Raumanzahl) {
		
		this.Adresse = Adresse;
		this.RaumAnzahl = Raumanzahl;
	}
	
	public void adresseAendern(String neue_Adresse) {
		
		this.Adresse = neue_Adresse;
	}
	
	public void raumanzahlAnpassen(int neue_raumanzahl) {
		
		this.RaumAnzahl = neue_raumanzahl;
	}
	
	public void raumHinzufuegen(Raum raum) {
		
		raumliste.add(raum);
		raum.gebaeudeZuweisen(this);
	}
	
}
